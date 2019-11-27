package org.mysql.sakila.domain

import java.io.Serializable
import java.time.*
import javax.persistence.*
import javax.validation.constraints.*

@Entity
@Table(name = "film_actor")
@IdClass(FilmActorId::class)
class FilmActor(

	// last_update
	@Column(name="last_update", nullable=false)
	val lastUpdate: ZonedDateTime,




	@Id
	@ManyToOne
	@JoinColumn(name = "actor_id")
	val actor: Actor,

	@Id
	@ManyToOne
	@JoinColumn(name = "film_id")
	val film: Film


): Serializable {

}


// https://stackoverflow.com/questions/23837561/jpa-2-0-many-to-many-with-extra-column
data class FilmActorId (
	
	val actor: Long = 0
	,
	val film: Long = 0

): Serializable

