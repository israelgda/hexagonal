package com.israelgda.hexagonal.adapters.output.mapper

import com.israelgda.hexagonal.adapters.output.client.response.AddressResponse
import com.israelgda.hexagonal.application.core.domain.Address

fun AddressResponse.toAdress() = Address(
    this.street,
    this.city,
    this.state,
    this.cep,
)
