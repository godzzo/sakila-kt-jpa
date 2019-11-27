package org.mysql.sakila.domain

import java.io.Serializable
import java.time.*
import javax.persistence.*
import javax.validation.constraints.*

@Entity
@Table(name = "inventory")

class Inventory(

	// last_update
	@Column(name="last_update", nullable=false)
	val lastUpdate: ZonedDateTime,


	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "film_id")
	val film: Film,

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "store_id")
	val store: Store,



	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "inventory_id")
	val id: Long = 0

): Serializable {

	@OneToMany(mappedBy = "inventory", cascade = [CascadeType.ALL], fetch = FetchType.LAZY)
	val rentals: MutableList<Rental> = mutableListOf()

}


