package com.israelgda.hexagonal.adapters.output.client

import com.israelgda.hexagonal.adapters.output.client.response.AddressResponse
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable

@FeignClient(
    name = "FindAdressByZipCodeClient",
    url = "\${integrations.clients.viacep.address.url}"
)
interface FindAdressByZipCodeClient {

    @GetMapping("/{zipCode}/json/")
    fun find(@PathVariable zipCode: String): AddressResponse
}