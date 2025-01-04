package com.israelgda.hexagonal.adapters.input.controller

import com.israelgda.hexagonal.adapters.input.controller.request.CustomerRequest
import com.israelgda.hexagonal.adapters.input.toCustomerInitialization
import com.israelgda.hexagonal.application.ports.input.InsertCustomerInputPort
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/customers")
class CustomerController(
    private val insertCustomerInputPort: InsertCustomerInputPort
) {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun insert(@Valid @RequestBody customerRequest: CustomerRequest) {
        return with(customerRequest) {
            insertCustomerInputPort.insert(
                toCustomerInitialization(),
                zipCode
            )
        }
    }
}