package org.mysql.sakila.controller

import org.mysql.sakila.domain.Actor
import org.mysql.sakila.repository.ActorRepository
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.domain.Specification
import org.springframework.data.rest.webmvc.PersistentEntityResource
import org.springframework.data.rest.webmvc.PersistentEntityResourceAssembler
import org.springframework.data.rest.webmvc.RepositoryRestController
import org.springframework.data.rest.webmvc.RootResourceInformation
import org.springframework.hateoas.CollectionModel
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

    // private static final String BASE_MAPPING = "/{repository}/{id}/{property}";

    // @QuerydslPredicate(root = [Actor::class.java])
    @RequestMapping(value = ["/{repository}/advanced"], method = arrayOf(RequestMethod.GET))
    fun advanced(@RequestParam("search") search : String,
               resourceInformation : RootResourceInformation,
               pageable: Pageable,
               assembler: PersistentEntityResourceAssembler) : ResponseEntity<CollectionModel<PersistentEntityResource>> {


        log.info("ActorController CALLED!!!");

        val specifications : Specification<Actor>? = Specification.where(
            Specification { root, query, cb ->
                val predicates = mutableListOf<Predicate>()

                predicates.add(cb.like(root.get<String>("firstName"), "${search}%"))
                predicates.add(cb.like(root.get<String>("lastName"), "${search}%"))

                cb.or(*predicates.toTypedArray())
            }
        )

        val result = repository.findAll(specifications, pageable);

        result.forEach() {
            log.info("row: ${it.id}");
        }

        return ResponseEntity(assembler.toCollectionModel(result), HttpStatus.OK);
    }

}
