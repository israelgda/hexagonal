package com.israelgda.hexagonal.adapters.input.controller.request

import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Pattern

data class CustomerRequest(
    @field:NotBlank(message = "Name must not be blank")
    val name: String,

    @field:NotBlank(message = "CPF must be on Brasilian pattern")
    @field:Pattern(regexp = "(\\d{3}.?\\d{3}.?\\d{3}-?\\d{2})")
    val cpf: String,

    @field:NotBlank(message = "Zipcode must be not blank")
    val zipCode: String,
)
