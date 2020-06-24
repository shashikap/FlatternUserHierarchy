package com.dbs.codetest.service;

import com.dbs.codetest.entity.TeamHierarchy;
import com.dbs.codetest.entity.User;
import com.dbs.codetest.entity.UserAccess;
import com.dbs.codetest.repository.TeamHierArchyRepository;
import com.dbs.codetest.repository.UserAccessRepository;
import com.dbs.codetest.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserAccessService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    TeamHierArchyRepository teamHierArchyRepository;

    @Autowired
    UserAccessRepository userAccessRepository;

    public List<User> getAllUsers() {
        return (List<User>) userRepository.findAll();
    }

    public List<UserAccess> addUserAccess(String empId) {
        List<UserAccess> userAccessList = getUsersAccess(teamHierArchyRepository.findById(empId).get());
        saveToUserAccess(userAccessList);
        return userAccessList;
    }

    public List<UserAccess> addAllUserAccess() {
        List<UserAccess> allUserAccessList = new ArrayList<>();
        teamHierArchyRepository.findAll()
                .forEach(teamHierarchy -> {
                    List<UserAccess> userAccessList = getUsersAccess(teamHierarchy);
                    saveToUserAccess(userAccessList);
                    allUserAccessList.addAll(userAccessList);
                });
        return allUserAccessList;

    }

    private List<UserAccess> getUsersAccess(TeamHierarchy teamHierarchy) {
        List<UserAccess> userAccessList = new ArrayList<>();
        User manager = getUserDetails(teamHierarchy.getEmpId()).get();

        if (teamHierarchy.getSubUsers().isEmpty()) {
            return addAndReturnSubUsersAccessOfLeafLevel(teamHierarchy.getEmpId(), teamHierarchy.getManager());
        }

        List<TeamHierarchy> oneLevelDownSubUsers =
                teamHierarchy.getSubUsers().stream().collect(Collectors.toList());

        List<TeamHierarchy> allSubUsers = oneLevelDownSubUsers.stream()
                .map(x -> x.getSubUsers())
                .flatMap(x -> x.stream())
                .distinct()
                .collect(Collectors.toList());

        // Since iteration goes one level down
        allSubUsers.addAll(oneLevelDownSubUsers);

        allSubUsers.forEach(x -> {
            userAccessList.add(createUserAccess(manager, x.getEmpId()));
        });

        return userAccessList;
    }

    private List<UserAccess> addAndReturnSubUsersAccessOfLeafLevel(String empId, TeamHierarchy manager) {
        User currentTeamMember = getUserDetails(empId).get();
        List<UserAccess> userAccessList = new ArrayList<>();

        manager.getSubUsers().forEach(x -> {
            userAccessList.add(createUserAccess(currentTeamMember, x.getEmpId()));
        });

        return userAccessList;
    }

    private UserAccess createUserAccess(User member, String empId) {

        UserAccess userAccess = new UserAccess(member.getEmpId(), member.getAccessKey(), member.getCountry());

        User subUser = getUserDetails(empId).get();

        userAccess.setSubUser(subUser.getEmpId());
        userAccess.setSubUseraccessKey(subUser.getAccessKey());
        userAccess.setSubUserCountry(subUser.getCountry());

        return userAccess;
    }

    private Optional<User> getUserDetails(String empId) {
        return userRepository.findById(empId);
    }

    private void saveToUserAccess(List<UserAccess> userAccessList) {
        userAccessRepository.saveAll(userAccessList);
    }
}


