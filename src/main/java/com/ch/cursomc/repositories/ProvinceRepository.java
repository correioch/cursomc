package com.ch.cursomc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ch.cursomc.domain.Province;

@Repository
public interface ProvinceRepository extends JpaRepository<Province, Integer> {

}
