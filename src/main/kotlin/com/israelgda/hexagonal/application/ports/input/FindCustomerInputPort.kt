package com.israelgda.hexagonal.application.ports.input

import com.israelgda.hexagonal.application.core.domain.Customer

interface FindCustomerInputPort {

    fun findById(id: Long): Customer
}