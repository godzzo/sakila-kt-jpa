package org.mysql.sakila.domain

import java.io.Serializable
import java.time.*
import javax.persistence.*
import javax.validation.constraints.*

@Entity
@Table(name = "store")

data class Store(

	// last_update
	@Column(name="last_update", nullable=false)
	val lastUpdate: ZonedDateTime,


	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "manager_staff_id")
	val managerStaff: Staff,

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "address_id")
	val address: Address,



	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "store_id")
	val id: Long = 0

): Serializable {

	@OneToMany(mappedBy = "store", cascade = [CascadeType.ALL], fetch = FetchType.LAZY)
	val customers: MutableList<Customer> = mutableListOf()

	@OneToMany(mappedBy = "store", cascade = [CascadeType.ALL], fetch = FetchType.LAZY)
	val inventories: MutableList<Inventory> = mutableListOf()

	@OneToMany(mappedBy = "store", cascade = [CascadeType.ALL], fetch = FetchType.LAZY)
	val staff: MutableList<Staff> = mutableListOf()

}


