package com.dbs.codetest.repository;

import com.dbs.codetest.entity.TeamHierarchy;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TeamHierArchyRepository extends CrudRepository<TeamHierarchy, String> {

}
