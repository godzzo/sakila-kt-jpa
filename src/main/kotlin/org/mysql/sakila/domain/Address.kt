package org.mysql.sakila.domain

import java.io.Serializable
import java.time.*
import javax.persistence.*
import javax.validation.constraints.*

@Entity
@Table(name = "address")

data class Address(

	// address
	@Column(name="address", length=50, nullable=false)
	val address: String,

	// address2
	@Column(name="address2", length=50, nullable=true)
	val address2: String,

	// district
	@Column(name="district", length=20, nullable=false)
	val district: String,

	// postal_code
	@Column(name="postal_code", length=10, nullable=true)
	val postalCode: String,

	// phone
	@Column(name="phone", length=20, nullable=false)
	val phone: String,

	// last_update
	@Column(name="last_update", nullable=false)
	val lastUpdate: ZonedDateTime,


	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "city_id")
	val city: City,



	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "address_id")
	val id: Long = 0

): Serializable {

	@OneToMany(mappedBy = "address", cascade = [CascadeType.ALL], fetch = FetchType.LAZY)
	val customers: MutableList<Customer> = mutableListOf()

	@OneToMany(mappedBy = "address", cascade = [CascadeType.ALL], fetch = FetchType.LAZY)
	val staff: MutableList<Staff> = mutableListOf()

	@OneToMany(mappedBy = "address", cascade = [CascadeType.ALL], fetch = FetchType.LAZY)
	val stores: MutableList<Store> = mutableListOf()

}


