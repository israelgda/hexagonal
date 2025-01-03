package com.israelgda.hexagonal.adapters.output.repository.entity

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.OneToOne

@Entity(
    name = "address"
)
data class AddressEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: String?,
    val street: String,
    val city: String,
    val state: String,
    val cep: String,

    @OneToOne
    @JoinColumn(name = "customer_id")
    val customer: CustomerEntity,
) {

}
