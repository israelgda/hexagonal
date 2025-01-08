package com.israelgda.hexagonal.application.ports.input

import com.israelgda.hexagonal.application.core.domain.Customer

interface UpdateCustomerInputPort {

    fun update(id: Long, customerRequested: Customer, zipCode: String): Customer
}