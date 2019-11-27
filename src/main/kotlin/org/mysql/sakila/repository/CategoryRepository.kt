package org.mysql.sakila.repository

import org.mysql.sakila.domain.Category

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface CategoryRepository : JpaRepository<Category, Long> 
