package com.example.casemodun6_be.repository;

import com.example.casemodun6_be.model.DetailAccount;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ISearchRepo extends PagingAndSortingRepository<DetailAccount,Long> {
    @Query(nativeQuery = true, value = "SELECT * FROM detail_account WHERE full_name LIKE concat('%',:full_name,'%')")
    List<DetailAccount> findByName(@Param("full_name") String full_name);


}
