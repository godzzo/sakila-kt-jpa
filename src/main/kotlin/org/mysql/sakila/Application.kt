package org.mysql.sakila

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.builder.SpringApplicationBuilder
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer
import org.springframework.boot.runApplication
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired



@SpringBootApplication
class Application : SpringBootServletInitializer() {
	override fun configure(application: SpringApplicationBuilder): SpringApplicationBuilder {
		println(">>>>> Application - configure - Called :)")
		log.info(">>>>> Application - configure - Called :)")

		return application.sources(Application::class.java)
	}
}

private val log = LoggerFactory.getLogger(Application::class.java)

fun main(args: Array<String>) {
	println(">>>>> Application - main - Called :)")
	log.info(">>>>> Application - main - Called :)")

	runApplication<Application>(*args)
}
