package org.mysql.sakila.domain

import java.io.Serializable
import java.time.*
import javax.persistence.*
import javax.validation.constraints.*

@Entity
@Table(name = "staff")

data class Staff(

	// first_name
	@Column(name="first_name", length=45, nullable=false)
	val firstName: String,

	// last_name
	@Column(name="last_name", length=45, nullable=false)
	val lastName: String,

	// picture
	@Column(name="picture", length=65535, nullable=true)
	val picture: String,

	// email
	@Column(name="email", length=50, nullable=true)
	val email: String,

	// active
	@Column(name="active", nullable=false)
	val active: Short,

	// username
	@Column(name="username", length=16, nullable=false)
	val username: String,

	// password
	@Column(name="password", length=40, nullable=true)
	val password: String,

	// last_update
	@Column(name="last_update", nullable=false)
	val lastUpdate: ZonedDateTime,


	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "address_id")
	val address: Address,

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "store_id")
	val store: Store,



	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "staff_id")
	val id: Long = 0

): Serializable {

	@OneToMany(mappedBy = "staff", cascade = [CascadeType.ALL], fetch = FetchType.LAZY)
	val payments: MutableList<Payment> = mutableListOf()

	@OneToMany(mappedBy = "staff", cascade = [CascadeType.ALL], fetch = FetchType.LAZY)
	val rentals: MutableList<Rental> = mutableListOf()

}


