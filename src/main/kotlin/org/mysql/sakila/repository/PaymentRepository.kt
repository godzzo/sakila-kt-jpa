package org.mysql.sakila.repository

import org.mysql.sakila.domain.Payment

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface PaymentRepository : JpaRepository<Payment, Long> 
