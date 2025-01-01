package com.israelgda.hexagonal.adapters.output.client

import com.israelgda.hexagonal.adapters.output.client.response.AddressResponse
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable

@FeignClient(
    name = "FindAdressByZipCodeClient",
    url = "\${integrations.clients.viacep.adress.url}"
)
interface FindAdressByZipCodeClient {

    @GetMapping("/{zipCode}/json/")
    fun finde(@PathVariable zipCode: String): AddressResponse
}