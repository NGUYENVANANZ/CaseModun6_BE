package com.example.casemodun6_be.repository;

import com.example.casemodun6_be.model.Account;
import com.example.casemodun6_be.model.Roles;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IRoleRepo extends CrudRepository<Roles,Long> {
    @Query(nativeQuery = true,value = "SELECT * from roles")
    List<Roles> getAll();
}