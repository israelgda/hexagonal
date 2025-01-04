package com.israelgda.hexagonal.application.ports.output

import com.israelgda.hexagonal.application.core.domain.Customer

interface FindCustomerOutputPort {

    fun findById(id: Long): Customer?
}