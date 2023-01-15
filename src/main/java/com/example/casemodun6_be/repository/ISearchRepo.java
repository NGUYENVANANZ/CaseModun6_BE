package com.example.casemodun6_be.repository;

import com.example.casemodun6_be.model.DetailAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.Year;
import java.util.List;

@Repository
public interface ISearchRepo extends PagingAndSortingRepository<DetailAccount,Long> {
    @Query(nativeQuery = true, value = "SELECT * FROM detail_account WHERE full_name LIKE concat('%',:full_name,'%') and status = 1")
    List<DetailAccount> findByName(@Param("full_name") String full_name);

    @Query(nativeQuery = true, value = "SELECT * FROM detail_account da join employ e on da.id = e.detail_account_id where " +
    "da.status = '1'" +
    "and da.gender = 'Nam' or da.gender = 'Nu'" +
            "and year(curdate()) - year(birthday) between '18' and '80'" +
            "and da.city = 'city'" +
            "and e.hires = 'hires'"
    )
    Iterable<DetailAccount> searchByAll(@Param("status") long status,
                                        @Param("gender") String gender,
                                        @Param("birthday") Year birthday,
                                        @Param("city") String city,
                                        @Param("hires") long hires);
}
