package com.ch.cursomc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ch.cursomc.domain.Ville;

@Repository
public interface VilleRepository extends JpaRepository<Ville, Integer> {

}
