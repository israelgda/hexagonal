package com.israelgda.hexagonal.adapters.output.client.response

data class AddressResponse(
    val street: String,
    val city: String,
    val state: String,
    val cep: String,
)
