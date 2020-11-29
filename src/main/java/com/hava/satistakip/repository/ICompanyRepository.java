package com.hava.satistakip.repository;

import com.hava.satistakip.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICompanyRepository extends JpaRepository<Company,Long> {
    @Query(value = "SELECT ID,NAME,ACTIVE,AIRPORT_ID FROM COMPANY WHERE NAME LIKE %?%",nativeQuery = true)
    List<Company> search(String search);
}
