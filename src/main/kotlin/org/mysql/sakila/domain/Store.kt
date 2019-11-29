package org.mysql.sakila.domain

import java.io.Serializable
import java.time.*
import javax.persistence.*
import javax.validation.constraints.*

@Entity
@Table(name = "store")

open class Store(

	// last_update
	@Column(name="last_update", nullable=false)
	var lastUpdate: ZonedDateTime,


	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "manager_staff_id")
	var managerStaff: Staff,

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "address_id")
	var address: Address,



	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "store_id")
	var id: Long = 0

) {

	@OneToMany(mappedBy = "store", cascade = [CascadeType.ALL], fetch = FetchType.LAZY)
	var customers: MutableList<Customer> = mutableListOf()

	@OneToMany(mappedBy = "store", cascade = [CascadeType.ALL], fetch = FetchType.LAZY)
	var inventories: MutableList<Inventory> = mutableListOf()

	@OneToMany(mappedBy = "store", cascade = [CascadeType.ALL], fetch = FetchType.LAZY)
	var staff: MutableList<Staff> = mutableListOf()

}


