package org.mysql.sakila.repository

import org.mysql.sakila.domain.FilmCategory

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface FilmCategoryRepository : JpaRepository<FilmCategory, Long> 
