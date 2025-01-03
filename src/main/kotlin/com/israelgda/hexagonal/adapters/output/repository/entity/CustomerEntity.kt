package com.israelgda.hexagonal.adapters.output.repository.entity

import com.israelgda.hexagonal.application.core.domain.Address
import com.israelgda.hexagonal.application.core.domain.Customer
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.OneToOne
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
    @OneToOne(mappedBy = "customer")
    var address: AddressEntity?,

    @NotNull
    val cpf: String,
    val isValidCpf: Boolean = false,
)
