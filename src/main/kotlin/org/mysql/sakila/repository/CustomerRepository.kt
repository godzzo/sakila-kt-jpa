package org.mysql.sakila.repository

import org.mysql.sakila.domain.Customer

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface CustomerRepository : JpaRepository<Customer, Long> 
