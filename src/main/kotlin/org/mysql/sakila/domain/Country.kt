package org.mysql.sakila.domain

import java.io.Serializable
import java.time.*
import javax.persistence.*
import javax.validation.constraints.*

@Entity
@Table(name = "country")
data class Country(

	// country
	@NotBlank
	@Column(name="country", length=50, nullable=false)
	val country: String,

	// last_update
	@Column(name="last_update", nullable=false)
	val lastUpdate: ZonedDateTime,

	@Min(3)
	@NotNull
	@Column(name="age", nullable=true)
	val age: Long? = 3,

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "country_id")
	val id: Long = 0

): Serializable {

	@OneToMany(mappedBy = "country", cascade = [CascadeType.ALL], fetch = FetchType.LAZY)
	val cities: MutableList<City> = mutableListOf()

}
