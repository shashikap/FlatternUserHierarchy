package com.dbs.codetest.controller;

//import com.dbs.codetest.entity.User;
import com.dbs.codetest.entity.User;
import com.dbs.codetest.entity.UserAccess;
import com.dbs.codetest.service.UserAccessService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController(value = "/user")
public class UserAccessController {

    @Autowired
    UserAccessService userAccessService;

    @ApiOperation(
            value = "This API will create user access for given user based on the hierarchy given",
            notes = "As per debug purpose its returning the list of user access for given user as the response, " +
                    "Hierarchy data should need to populate as this api to work"
    )
    @RequestMapping(value = "/addUserAccess/{empId}", method = RequestMethod.POST)
    public ResponseEntity<List<UserAccess>> addUserAccess(@PathVariable String empId){
        return new ResponseEntity<List<UserAccess>>(userAccessService.addUserAccess(empId), HttpStatus.CREATED);
    }

    @ApiOperation(
            value = "This API will create user access for all the users based on the hierarchy given",
            notes = "As per debug purpose its returning the list of user access for alls users as the response, " +
                    "Hierarchy data should need to populate as this api to work"
    )
    @RequestMapping(value = "/addAllUserAccess", method = RequestMethod.POST)
    public ResponseEntity<List<UserAccess>> addAllUserAccess(){
        return new ResponseEntity<List<UserAccess>>(userAccessService.addAllUserAccess(),HttpStatus.CREATED);
    }

    @ApiOperation(
            value = "This API will return all the users in user table",
            hidden = true
    )
    @RequestMapping(value = "getAllUsers", method = RequestMethod.GET)
    public ResponseEntity<List<User>> getAllUsers(){
        return new ResponseEntity<List<User>>(userAccessService.getAllUsers(), HttpStatus.OK);
    }


}
