package org.mysql.sakila.repository

import org.mysql.sakila.domain.Country

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface CountryRepository : JpaRepository<Country, Long> 
