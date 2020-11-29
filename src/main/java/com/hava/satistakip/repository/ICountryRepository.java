package com.hava.satistakip.repository;

import com.hava.satistakip.model.common.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICountryRepository extends JpaRepository<Country,Long> {
}
