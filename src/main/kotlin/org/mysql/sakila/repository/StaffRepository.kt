package org.mysql.sakila.repository

import org.mysql.sakila.domain.Staff

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface StaffRepository : JpaRepository<Staff, Long> 
