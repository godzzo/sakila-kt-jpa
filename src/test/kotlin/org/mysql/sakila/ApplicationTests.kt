package org.mysql.sakila.sakila

import org.junit.jupiter.api.Test
import org.mysql.sakila.repository.ActorRepository
import org.mysql.sakila.repository.StoreRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.data.jpa.domain.Specification

@SpringBootTest
class ApplicationTests {

	@Autowired
	val storeRepository: StoreRepository? = null

	@Autowired
	val actorRepository: ActorRepository? = null

	@Test
	fun testStores() {
		val stores = storeRepository?.findAll()

		stores?.forEach {
			println("id: ${it.id}")
		}
	}

	@Test
	fun testActors() {
		actorRepository.findAll(Specification.where())
	}
}
