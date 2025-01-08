package com.israelgda.hexagonal.application.core.domain

data class Customer(
    var id: Long? = null,
    var name: String,
    var street: String? = null,
    var city: String? = null,
    var state: String? = null,
    var cpf: String,
){
    constructor(): this(
        null,
        "",
        "",
        "",
        "",
        "",
    )
}