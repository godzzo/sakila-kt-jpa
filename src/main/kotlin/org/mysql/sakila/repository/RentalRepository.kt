package org.mysql.sakila.repository

import org.mysql.sakila.domain.Rental

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface RentalRepository : JpaRepository<Rental, Long> 
