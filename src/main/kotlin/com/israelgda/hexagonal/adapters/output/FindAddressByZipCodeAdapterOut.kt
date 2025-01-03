package com.israelgda.hexagonal.adapters.output

import com.israelgda.hexagonal.adapters.output.client.FindAdressByZipCodeClient
import com.israelgda.hexagonal.adapters.output.mapper.toAdress
import com.israelgda.hexagonal.application.core.domain.Address
import com.israelgda.hexagonal.application.ports.output.FindAddressByZipCodeOutputPort
import org.springframework.stereotype.Component

@Component
class FindAddressByZipCodeAdapterOut(
    private val client: FindAdressByZipCodeClient,
): FindAddressByZipCodeOutputPort {

    override fun find(zipCode: String): Address =
        client.find(zipCode).toAdress()

}