package com.israelgda.hexagonal.application.core.domain

data class Customer(
    val id: Long? = null,
    val name: String,
    var street: String? = null,
    var city: String? = null,
    var state: String? = null,
    val cpf: String,
    val isValidCpf: Boolean = false,
){
    constructor(): this(
        null,
        "",
        "",
        "",
        "",
        "",
        false
    )
}