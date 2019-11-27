package org.mysql.sakila.domain

import java.io.Serializable
import java.time.*
import javax.persistence.*
import javax.validation.constraints.*

@Entity
@Table(name = "category")

class Category(

	// name
	@Column(name="name", length=25, nullable=false)
	val name: String,

	// last_update
	@Column(name="last_update", nullable=false)
	val lastUpdate: ZonedDateTime,




	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "category_id")
	val id: Long = 0

): Serializable {

	@OneToMany(mappedBy = "category", cascade = [CascadeType.ALL], fetch = FetchType.LAZY)
	val filmCategories: MutableList<FilmCategory> = mutableListOf()

}


