package org.mysql.sakila.repository

import org.mysql.sakila.domain.Language

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface LanguageRepository : JpaRepository<Language, Long> 
