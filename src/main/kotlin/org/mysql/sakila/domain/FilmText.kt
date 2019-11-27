package org.mysql.sakila.domain

import java.io.Serializable
import java.time.*
import javax.persistence.*
import javax.validation.constraints.*

@Entity
@Table(name = "film_text")

data class FilmText(

	// title
	@Column(name="title", length=255, nullable=false)
	val title: String,

	// description
	@Column(name="description", length=65535, nullable=true)
	val description: String,




	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "film_id")
	val id: Long = 0

): Serializable {

}


