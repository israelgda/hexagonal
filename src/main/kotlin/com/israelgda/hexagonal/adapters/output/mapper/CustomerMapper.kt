package com.israelgda.hexagonal.adapters.output.mapper

import com.israelgda.hexagonal.adapters.output.client.response.AddressResponse
import com.israelgda.hexagonal.adapters.output.repository.entity.CustomerEntity
import com.israelgda.hexagonal.application.core.domain.Address
import com.israelgda.hexagonal.application.core.domain.Customer

fun Customer.toEntity() = CustomerEntity(
    this.id,
    this.name,
    this.street!!,
    this.city!!,
    this.state!!,
    this.cpf,
)
