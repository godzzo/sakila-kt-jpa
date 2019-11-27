package org.mysql.sakila.domain

import org.hibernate.annotations.Fetch
import org.hibernate.annotations.FetchMode
import java.io.Serializable
import java.time.*
import javax.persistence.*
import javax.validation.constraints.*

@Entity
@Table(name = "customer")

class Customer(

	// first_name
	@Column(name="first_name", length=45, nullable=false)
	val firstName: String,

	// last_name
	@Column(name="last_name", length=45, nullable=false)
	val lastName: String,

	// email
	@Column(name="email", length=50, nullable=true)
	val email: String,

	// active
	@Column(name="active", nullable=false)
	val active: Short,

	// create_date
	@Column(name="create_date", nullable=false)
	val createDate: ZonedDateTime,

	// last_update
	@Column(name="last_update", nullable=false)
	val lastUpdate: ZonedDateTime,


	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "store_id")
//	@Fetch(FetchMode.JOIN)
	val store: Store,

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "address_id")
	val address: Address,



	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "customer_id")
	val id: Long = 0

): Serializable {

	@OneToMany(mappedBy = "customer", cascade = [CascadeType.ALL], fetch = FetchType.LAZY)
	val payments: MutableList<Payment> = mutableListOf()

	@OneToMany(mappedBy = "customer", cascade = [CascadeType.ALL], fetch = FetchType.LAZY)
	val rentals: MutableList<Rental> = mutableListOf()

}


