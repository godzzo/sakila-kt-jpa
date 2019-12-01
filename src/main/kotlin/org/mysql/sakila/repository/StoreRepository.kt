package org.mysql.sakila.repository

import org.mysql.sakila.domain.Store
import org.springframework.beans.factory.annotation.Autowired

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param
import org.springframework.data.rest.core.annotation.RestResource
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager
import javax.persistence.criteria.CriteriaBuilder
import javax.persistence.criteria.CriteriaQuery
import javax.persistence.criteria.Predicate

@Repository
interface StoreRepository : JpaRepository<Store, Long>, StoreRepositoryCustom {
    @RestResource(rel = "ex-id", path="ex-id")
    override fun findByExId(@Param("id") id: Long): MutableList<Store>
}

interface StoreRepositoryCustom {
    @RestResource(rel = "ex-id", path="ex-id")
    fun findByExId(@Param("id") id: Long): MutableList<Store>
}

@Repository
class StoreRepositoryImpl : StoreRepositoryCustom {
    @Autowired
    val entityManager: EntityManager? = null

    @RestResource(rel = "ex-id", path="ex-id")
    override fun findByExId(id: Long): MutableList<Store> {
        val em = entityManager;

        if (em != null) {
            val cb = em.getCriteriaBuilder()
            val cq = cb.createQuery(Store::class.java)


            val store = cq.from(Store::class.java)
            val predicates : MutableList<Predicate> = mutableListOf()

            predicates.add(cb.equal(store.get<Long>("id"), id))

            cq.where(*predicates.toTypedArray())

            val query = em.createQuery(cq)

            return query.getResultList()

        } else {
            return mutableListOf<Store>()
        }
    }
}
