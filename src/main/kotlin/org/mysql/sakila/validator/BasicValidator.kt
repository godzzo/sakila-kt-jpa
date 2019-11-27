package org.mysql.sakila.validator

import org.slf4j.LoggerFactory
import org.springframework.validation.Errors
import org.springframework.validation.Validator
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean

class BasicValidator : Validator {
    private val log = LoggerFactory.getLogger(BasicValidator::class.java)

    override fun supports(clazz: Class<*>): Boolean {
        log.info("supports clazz: ${clazz}")

        return true
    }

    override fun validate(target: Any, errors: Errors) {

        log.info("validate class: ${target.javaClass}")
        log.info("validate value: ${target.toString()}")

        val validator = LocalValidatorFactoryBean()
        validator.afterPropertiesSet()

        validator.validate(target, errors)

        log.info("validate errors: ${errors.toString()}")
    }
}