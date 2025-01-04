package com.israelgda.hexagonal.adapters.input.controller

import com.israelgda.hexagonal.adapters.input.controller.request.CustomerRequest
import com.israelgda.hexagonal.adapters.input.toCustomerInitialization
import com.israelgda.hexagonal.adapters.input.toCustomerResponse
import com.israelgda.hexagonal.application.ports.input.FindCustomerInputPort
import com.israelgda.hexagonal.application.ports.input.InsertCustomerInputPort
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v1/customers")
class CustomerController(
    private val insertCustomerInputPort: InsertCustomerInputPort,
    private val findCustomerInputPort: FindCustomerInputPort,
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

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    fun findCustomer(@PathVariable id: Long)
        = findCustomerInputPort.findById(id)
            .toCustomerResponse()

}