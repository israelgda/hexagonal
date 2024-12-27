package com.israelgda.hexagonal.application.core.domain

data class Address(
    val street: String,
    val city: String,
    val state: String,
    val cep: String,
)
