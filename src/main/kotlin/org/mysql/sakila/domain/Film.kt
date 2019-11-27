package org.mysql.sakila.domain

import com.fasterxml.jackson.annotation.JsonIgnore
import java.io.Serializable
import java.time.*
import javax.persistence.*
import javax.validation.constraints.*

@Entity
@Table(name = "film")

class Film(

	// title
	@Column(name="title", length=255, nullable=false)
	val title: String,

	// description
	@Column(name="description", length=65535, nullable=true)
	val description: String,

	// release_year
	@Column(name="release_year", nullable=true)
	val releaseYear: Short,

	// rental_duration
	@Column(name="rental_duration", nullable=false)
	val rentalDuration: Short,

	// rental_rate
	@Column(name="rental_rate", nullable=false)
	val rentalRate: Double,

	// length
	@Column(name="length", nullable=true)
	val length: Short,

	// replacement_cost
	@Column(name="replacement_cost", nullable=false)
	val replacementCost: Double,

	// rating
	@Column(name="rating", length=5, nullable=true)
	val rating: String,

	// special_features
	@Column(name="special_features", length=54, nullable=true)
	val specialFeatures: String,

	// last_update
	@Column(name="last_update", nullable=false)
	val lastUpdate: ZonedDateTime,


	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "language_id")
	val language: Language,

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "original_language_id")
	val originalLanguage: Language,



	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "film_id")
	val id: Long = 0

): Serializable {

//	@JsonIgnore
	@OneToMany(mappedBy = "film", cascade = [CascadeType.ALL], fetch = FetchType.LAZY)
	val filmActors: MutableList<FilmActor> = mutableListOf()

//	@JsonIgnore
	@OneToMany(mappedBy = "film", cascade = [CascadeType.ALL], fetch = FetchType.LAZY)
	val filmCategories: MutableList<FilmCategory> = mutableListOf()

//	@JsonIgnore
	@OneToMany(mappedBy = "film", cascade = [CascadeType.ALL], fetch = FetchType.LAZY)
	val inventories: MutableList<Inventory> = mutableListOf()

}


