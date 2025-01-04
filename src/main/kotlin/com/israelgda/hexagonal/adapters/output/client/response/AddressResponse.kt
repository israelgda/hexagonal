package com.israelgda.hexagonal.adapters.output.client.response

import com.fasterxml.jackson.annotation.JsonProperty

data class AddressResponse(
    @JsonProperty("logradouro")
    val street: String,
    @JsonProperty("localidade")
    val city: String,
    @JsonProperty("estado")
    val state: String,
    val cep: String,
)
