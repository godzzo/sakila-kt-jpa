package org.mysql.sakila.util

import javax.persistence.criteria.CriteriaBuilder
import javax.persistence.criteria.CriteriaQuery
import javax.persistence.criteria.Predicate
import javax.persistence.criteria.Root

object FilterHelper {

    fun like(root: Root<*>, q: CriteriaQuery<*>, cb: CriteriaBuilder,
             predicates: MutableList<Predicate>, name: String?, value: String?) {
        if (value != null) {
            predicates.add(cb.like(root.get(name), "${value}%"))
        }
    }

    fun eq(root: Root<*>, q: CriteriaQuery<*>, cb: CriteriaBuilder,
              predicates: MutableList<Predicate>, name: String?, value: String?) {
        if (value != null) {
            predicates.add(cb.equal(root.get<String>(name), value))
        }
    }

}
