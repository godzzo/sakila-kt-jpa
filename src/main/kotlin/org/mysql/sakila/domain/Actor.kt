package org.mysql.sakila.domain

import java.io.Serializable
import java.time.*
import javax.persistence.*
import javax.validation.constraints.*

@Entity
@Table(name = "actor")

open class Actor(

	// first_name
	@Column(name="first_name", length=45, nullable=false)
	val firstName: String,

	// last_name
	@Column(name="last_name", length=45, nullable=false)
	val lastName: String,

	// last_update
	@Column(name="last_update", nullable=false)
	val lastUpdate: ZonedDateTime,




	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "actor_id")
	val id: Long = 0

): Serializable {

	@OneToMany(mappedBy = "actor", cascade = [CascadeType.ALL], fetch = FetchType.LAZY)
	val filmActors: MutableList<FilmActor> = mutableListOf()

}


