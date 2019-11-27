package org.mysql.sakila

import org.mysql.sakila.domain.*
import org.mysql.sakila.validator.BasicValidator
import org.slf4j.LoggerFactory
import org.springframework.data.rest.core.config.RepositoryRestConfiguration
import org.springframework.data.rest.core.event.ValidatingRepositoryEventListener
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer
import org.springframework.stereotype.Component
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.validation.Validator


@Component
class RepositoryRestCustomization : RepositoryRestConfigurer {
    private val log = LoggerFactory.getLogger(RepositoryRestCustomization::class.java)

    init {
        println("RepositoryRestCustomization: INIT")
        log.warn("configureRepositoryRestConfiguration: INIT")

    }

    override fun configureRepositoryRestConfiguration(config: RepositoryRestConfiguration?) {
        println("RepositoryRestCustomization: CALLED")
        log.warn("configureRepositoryRestConfiguration: CALLED")

        config?.exposeIdsFor(
            Actor::class.java,
            Address::class.java,
            Category::class.java,
            City::class.java,
            Country::class.java,
            Customer::class.java,
            Film::class.java,
            FilmActor::class.java,
            FilmCategory::class.java,
            FilmText::class.java,
            Inventory::class.java,
            Language::class.java,
            Payment::class.java,
            Rental::class.java,
            Staff::class.java,
            Store::class.java
        );
    }

    @Autowired
    private val validator: Validator? = null

    override fun configureValidatingRepositoryEventListener(validatingListener: ValidatingRepositoryEventListener?) {
        println("configureValidatingRepositoryEventListener: CALLED")
        log.warn("configureValidatingRepositoryEventListener: CALLED validator: ${validator?.javaClass}")

        validatingListener?.addValidator("beforeSave", validator)
        validatingListener?.addValidator("beforeCreate", validator)
    }
}
