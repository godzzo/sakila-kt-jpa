package org.mysql.sakila.controller

import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

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
}

data class CustomFilter(
    val name: String?,
    val age: Int?,
    val isGod: Boolean = true
) {
}
