package org.mysql.sakila.repository

import org.mysql.sakila.domain.Inventory

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface InventoryRepository : JpaRepository<Inventory, Long> 
