package com.ch.cursomc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ch.cursomc.domain.Commande;

@Repository
public interface CommandeRepository extends JpaRepository<Commande, Integer> {

}
