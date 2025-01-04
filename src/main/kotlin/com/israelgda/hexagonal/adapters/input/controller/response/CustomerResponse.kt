package com.israelgda.hexagonal.adapters.input.controller.response

data class CustomerResponse(
    val id: Long?,
    val name: String,
    var street: String,
    var city: String,
    var state: String,
    val cpf: String,
    val isValidCpf: Boolean,
) {
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
