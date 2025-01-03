package com.israelgda.hexagonal.adapters.output.repository.entity

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import org.jetbrains.annotations.NotNull

@Entity(
    name = "customer"
)
data class CustomerEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: String?,

    @NotNull
    val name: String,

    @NotNull
    val street: String,

    @NotNull
    val city: String,

    @NotNull
    val state: String,

    @NotNull
    val cpf: String,

    val isValidCpf: Boolean = false,
)
