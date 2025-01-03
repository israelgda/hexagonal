package com.israelgda.hexagonal.adapters.input

import com.israelgda.hexagonal.adapters.input.controller.request.CustomerRequest
import com.israelgda.hexagonal.application.core.domain.Customer

fun CustomerRequest.toCustomerInitialization() = Customer(
    name = this.name,
    cpf = this.cpf,
)