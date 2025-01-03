package com.israelgda.hexagonal.adapters.output.repository.entity

import jakarta.persistence.JoinColumn
import jakarta.persistence.OneToOne

data class AddressEntity(
    val street: String,
    val city: String,
    val state: String,
)
