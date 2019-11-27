package org.mysql.sakila.repository

import org.mysql.sakila.domain.City

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface CityRepository : JpaRepository<City, Long> 
