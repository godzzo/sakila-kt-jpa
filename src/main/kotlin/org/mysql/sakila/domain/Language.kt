package org.mysql.sakila.domain

import java.io.Serializable
import java.time.*
import javax.persistence.*
import javax.validation.constraints.*

@Entity
@Table(name = "language")

data class Language(

	// name
	@Column(name="name", length=20, nullable=false)
	val name: Char,

	// last_update
	@Column(name="last_update", nullable=false)
	val lastUpdate: ZonedDateTime,




	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "language_id")
	val id: Long = 0

): Serializable {

	@OneToMany(mappedBy = "language", cascade = [CascadeType.ALL], fetch = FetchType.LAZY)
	val films: MutableList<Film> = mutableListOf()

}


