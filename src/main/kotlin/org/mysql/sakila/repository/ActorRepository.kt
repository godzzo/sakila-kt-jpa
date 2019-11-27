package org.mysql.sakila.repository

import org.mysql.sakila.domain.Actor

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor
import org.springframework.stereotype.Repository;

@Repository
interface ActorRepository : JpaRepository<Actor, Long>, JpaSpecificationExecutor<Actor>
