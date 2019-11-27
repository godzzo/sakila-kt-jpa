package org.mysql.sakila.domain

import java.io.Serializable
import java.time.*
import javax.persistence.*
import javax.validation.constraints.*

@Entity
@Table(name = "rental")

class Rental(

	// rental_date
	@Column(name="rental_date", nullable=false)
	val rentalDate: ZonedDateTime,

	// return_date
	@Column(name="return_date", nullable=true)
	val returnDate: ZonedDateTime,

	// last_update
	@Column(name="last_update", nullable=false)
	val lastUpdate: ZonedDateTime,


	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "inventory_id")
	val inventory: Inventory,

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "customer_id")
	val customer: Customer,

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "staff_id")
	val staff: Staff,



	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "rental_id")
	val id: Long = 0

): Serializable {

	@OneToMany(mappedBy = "rental", cascade = [CascadeType.ALL], fetch = FetchType.LAZY)
	val payments: MutableList<Payment> = mutableListOf()

}


