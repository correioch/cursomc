package com.ch.cursomc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ch.cursomc.domain.ArticleCommande;

@Repository
public interface ArticleCommandeRepository extends JpaRepository<ArticleCommande, Integer> {

}
