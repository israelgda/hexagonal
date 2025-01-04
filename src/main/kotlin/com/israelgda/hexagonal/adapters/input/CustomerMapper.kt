package com.israelgda.hexagonal.adapters.input

import com.israelgda.hexagonal.adapters.input.controller.request.CustomerRequest
import com.israelgda.hexagonal.adapters.input.controller.response.CustomerResponse
import com.israelgda.hexagonal.adapters.output.repository.entity.CustomerEntity
import com.israelgda.hexagonal.application.core.domain.Customer

fun CustomerRequest.toCustomerInitialization() = Customer(
    name = this.name,
    cpf = this.cpf,
)

fun CustomerEntity.toCustomer() = Customer(
    id = this.id!!,
    name = this.name,
    street = this.street,
    city = this.city,
    state = this.state,
    cpf = this.cpf,
    isValidCpf = this.isValidCpf,
)

fun Customer.toCustomerResponse() = CustomerResponse(
    id = this.id,
    name = this.name,
    street = this.street!!,
    city = this.city!!,
    state = this.state!!,
    cpf = this.cpf,
    isValidCpf = this.isValidCpf,
)