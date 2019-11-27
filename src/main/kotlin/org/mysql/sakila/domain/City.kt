package org.mysql.sakila.domain

import java.io.Serializable
import java.time.*
import javax.persistence.*
import javax.validation.constraints.*

@Entity
@Table(name = "city")

class City(
	// city
	@Column(name="city", length=50, nullable=false)
	val city: String,

	// last_update
	@Column(name="last_update", nullable=false)
	val lastUpdate: ZonedDateTime,

	@field:NotBlank
	@Column(name="summer_note", nullable=false)
	val summerNote: String,

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "country_id")
	val country: Country,



	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "city_id")
	val id: Long = 0

): Serializable {

	@OneToMany(mappedBy = "city", cascade = [CascadeType.ALL], fetch = FetchType.LAZY)
	val addresses: MutableList<Address> = mutableListOf()

}


