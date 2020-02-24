package org.mysql.sakila.controller

import org.mysql.sakila.domain.Actor
import org.mysql.sakila.util.FilterHelper
import org.slf4j.LoggerFactory
import org.springframework.data.jpa.domain.Specification
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController
import javax.persistence.criteria.CriteriaBuilder
import javax.persistence.criteria.CriteriaQuery
import javax.persistence.criteria.Predicate
import javax.persistence.criteria.Root

@RestController
class TestController(
) {
    val log = LoggerFactory.getLogger(TestController::class.java)

    init {
        log.info("TestController INITIALIZED...");
    }

    @RequestMapping(value = ["/test/one"], method = arrayOf(RequestMethod.GET))
    fun one(filter: CustomFilter) : MutableMap<String, Any> {

        log.info("TestController CALLED!!! filter: ${filter}");

        val map = mutableMapOf<String, Any>();

        map.put("success", true)

        return map;
    }

    fun createSpecifications(filter: CustomFilter): Specification<Actor>? = Specification.where(
            Specification { root, query, cb ->
                val predicates = mutableListOf<Predicate>()

                FilterHelper.like(root, query, cb, predicates, "firstName", filter.name);
                FilterHelper.like(root, query, cb, predicates, "lastName", filter.name);

                cb.or(*predicates.toTypedArray())
            }
    )
}

/*
NameConvention
    DateFrom - DateTo, DateTimeFrom - DateTimeTo, TimeFrom - TimeTo
        Between
    LessThan, MoreThan
        NumberMin, NumberMax, NumberEqMin, NumberEqMax
    LessThan, MoreThan
        LessThanAndEqual, MoreThanAndEqual
    Field
        Equal
    FieldIn
        InList
FieldValue - byType
    Number, String, Boolean, Date, DateTime, Time, Binary - FileUpload?
    Join - got the id
 */

data class CustomFilter(
    val name: String?,
    val age: Int?,
    val isGod: Boolean = true
) {
}

