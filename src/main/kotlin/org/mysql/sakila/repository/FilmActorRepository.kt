package org.mysql.sakila.repository

import org.mysql.sakila.domain.FilmActor

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface FilmActorRepository : JpaRepository<FilmActor, Long> 
