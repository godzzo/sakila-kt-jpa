package org.mysql.sakila.repository

import org.mysql.sakila.domain.FilmText

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface FilmTextRepository : JpaRepository<FilmText, Long> 
