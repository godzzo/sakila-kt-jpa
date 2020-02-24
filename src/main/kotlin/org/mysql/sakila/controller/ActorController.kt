package org.mysql.sakila.controller

import org.mysql.sakila.domain.Actor
import org.mysql.sakila.repository.ActorRepository
import org.mysql.sakila.util.FilterHelper
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.domain.Specification
import org.springframework.data.rest.webmvc.RepositoryRestController
import org.springframework.data.web.PagedResourcesAssembler
import org.springframework.hateoas.EntityModel
import org.springframework.hateoas.PagedModel
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RequestParam
import javax.persistence.criteria.Predicate


@Controller
@RepositoryRestController
class ActorController(
        @Autowired val repository: ActorRepository
) {
    val log = LoggerFactory.getLogger(ActorController::class.java)

    init {
        log.info("ActorController INITIALIZED...");
    }

    @RequestMapping(value = ["/{repository}/actorsSearch"], method = arrayOf(RequestMethod.GET))
    fun actorsSearch(@RequestParam("search") search : String,
         pageable: Pageable,
         assembler: PagedResourcesAssembler<Actor>) : ResponseEntity<PagedModel<EntityModel<Actor>>> {

        val specifications = createSpecifications(search)
        val result = repository.findAll(specifications, pageable);

        return ResponseEntity(assembler.toModel(result), HttpStatus.OK);
    }

    fun createSpecifications(search: String): Specification<Actor>? = Specification.where(
        Specification { root, query, cb ->
            val predicates = mutableListOf<Predicate>()

            // predicates.add(cb.like(root.get<String>("firstName"), "${search}%"))
            // predicates.add(cb.like(root.get<String>("lastName"), "${search}%"))

            FilterHelper.like(root, query, cb, predicates, "firstName", search);
            FilterHelper.like(root, query, cb, predicates, "lastName", search);


            cb.or(*predicates.toTypedArray())
        }
    )
}
