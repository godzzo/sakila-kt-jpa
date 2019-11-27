package org.mysql.sakila.repository

import org.mysql.sakila.domain.Address

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface AddressRepository : JpaRepository<Address, Long> 
