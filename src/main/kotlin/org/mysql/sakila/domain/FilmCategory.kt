package org.mysql.sakila.domain

import java.io.Serializable
import java.time.*
import javax.persistence.*
import javax.validation.constraints.*

@Entity
@Table(name = "film_category")
@IdClass(FilmCategoryId::class)
data class FilmCategory(

	// last_update
	@Column(name="last_update", nullable=false)
	val lastUpdate: ZonedDateTime,




	@Id
	@ManyToOne
	@JoinColumn(name = "film_id")
	val film: Film,

	@Id
	@ManyToOne
	@JoinColumn(name = "category_id")
	val category: Category


): Serializable {

}


// https://stackoverflow.com/questions/23837561/jpa-2-0-many-to-many-with-extra-column
data class FilmCategoryId (
	
	val film: Long = 0
	,
	val category: Long = 0

): Serializable

