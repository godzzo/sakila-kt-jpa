package org.mysql.sakila.repository

import org.mysql.sakila.domain.Store

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface StoreRepository : JpaRepository<Store, Long> 
