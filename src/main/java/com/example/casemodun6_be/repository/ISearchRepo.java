package com.example.casemodun6_be.repository;

import com.example.casemodun6_be.model.DetailAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.time.LocalDate;
import java.time.Year;
import java.util.List;

@Repository
public interface ISearchRepo extends PagingAndSortingRepository<DetailAccount, Long> {
    @Query(nativeQuery = true, value = "SELECT * FROM detail_account WHERE full_name LIKE concat('%',:full_name,'%') and status = 1")
    List<DetailAccount> findByName(@Param("full_name") String full_name);

//    @Query(nativeQuery = true, value = "SELECT * FROM detail_account where gender = :gender and 18 <= and city = :city")
    @Query(nativeQuery = true, value = "SELECT * from detail_account where gender=:gender and birthday=:birthday and city=:city")
    List<DetailAccount> searchByAll(
            @Param("gender") String gender,
            @Param("birthday") Date birthday,
            @Param("city") String city);

}
