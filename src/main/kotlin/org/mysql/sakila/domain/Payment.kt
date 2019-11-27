package org.mysql.sakila.domain

import java.io.Serializable
import java.time.*
import javax.persistence.*
import javax.validation.constraints.*

@Entity
@Table(name = "payment")

class Payment(

	// amount
	@Column(name="amount", nullable=false)
	val amount: Double,

	// payment_date
	@Column(name="payment_date", nullable=false)
	val paymentDate: ZonedDateTime,

	// last_update
	@Column(name="last_update", nullable=false)
	val lastUpdate: ZonedDateTime,


	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "customer_id")
	val customer: Customer,

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "staff_id")
	val staff: Staff,

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "rental_id")
	val rental: Rental,



	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "payment_id")
	val id: Long = 0

): Serializable {

}


