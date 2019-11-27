package org.mysql.sakila.sakila

import org.junit.jupiter.api.Test
import org.mysql.sakila.repository.ActorRepository
import org.mysql.sakila.repository.StoreRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.data.jpa.domain.Specification
import org.springframework.transaction.annotation.Transactional

@SpringBootTest
class ApplicationTests {

	@Autowired
	val storeRepository: StoreRepository? = null

	@Autowired
	val actorRepository: ActorRepository? = null

	@Test
	@Transactional
	fun testStores() {
		val stores = storeRepository?.findAll()

		// println("${stores?.get(0)?.id}")

		stores?.forEach {
			println("id: ${it.id}")
//			println("manager: ${it.managerStaff.firstName} ${it.managerStaff.lastName}")
		}
	}

	@Test
	fun testActors() {
		// actorRepository.findAll(Specification.where())
	}
}
