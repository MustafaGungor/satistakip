package com.hava.satistakip.repository;

import com.hava.satistakip.model.common.Town;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITownRepository extends JpaRepository<Town,Long> {
}
