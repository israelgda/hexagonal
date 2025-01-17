package com.israelgda.hexagonal.adapters.input.controller

import com.israelgda.hexagonal.adapters.input.controller.request.CustomerRequest
import com.israelgda.hexagonal.adapters.input.toCustomerInitialization
import com.israelgda.hexagonal.adapters.input.toCustomerResponse
import com.israelgda.hexagonal.application.ports.input.DeleteCustomerInputPort
import com.israelgda.hexagonal.application.ports.input.FindCustomerInputPort
import com.israelgda.hexagonal.application.ports.input.InsertCustomerInputPort
import com.israelgda.hexagonal.application.ports.input.UpdateCustomerInputPort
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v1/customers")
class CustomerController(
    private val insertCustomerInputPort: InsertCustomerInputPort,
    private val findCustomerInputPort: FindCustomerInputPort,
    private val updateCustomerInputPort: UpdateCustomerInputPort,
    private val deleteCustomerInputPort: DeleteCustomerInputPort,
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
    fun find(@PathVariable id: Long)
        = findCustomerInputPort.findById(id)
            .toCustomerResponse()

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    fun update(
        @PathVariable id: Long,
        @Valid @RequestBody customerRequested: CustomerRequest,
    ) = updateCustomerInputPort.update(
        id,
        customerRequested.toCustomerInitialization(),
        customerRequested.zipCode
    )

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deleteById(@PathVariable id: Long) =
        deleteCustomerInputPort.deleteById(id)
}