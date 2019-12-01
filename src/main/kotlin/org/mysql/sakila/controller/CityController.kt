package org.mysql.sakila.controller

import org.mysql.sakila.Application
import org.mysql.sakila.domain.City
import org.mysql.sakila.repository.CityRepository
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Pageable
import org.springframework.data.rest.webmvc.PersistentEntityResource
import org.springframework.data.rest.webmvc.PersistentEntityResourceAssembler
import org.springframework.data.rest.webmvc.RepositoryRestController
import org.springframework.data.web.PagedResourcesAssembler
import org.springframework.hateoas.CollectionModel
import org.springframework.hateoas.EntityModel
import org.springframework.hateoas.PagedModel
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod

@Controller
@RepositoryRestController
class CityController(
        @Autowired val repository: CityRepository
) {
    val log = LoggerFactory.getLogger(CityController::class.java)

    init {
        log.info("CityController INITIALIZED...");
    }

    @RequestMapping(value = ["/api/cities/advanced"], method = arrayOf(RequestMethod.GET))
    fun cities(pageable: Pageable,
                assembler: PersistentEntityResourceAssembler) : ResponseEntity<CollectionModel<PersistentEntityResource>> {

        log.info("CityController CALLED!!!");

        val persons = repository.findAll(pageable);

        persons.forEach() {
            log.info("row: ${it.id}");
        }

        return ResponseEntity(assembler.toCollectionModel(persons), HttpStatus.OK);
    }
}
