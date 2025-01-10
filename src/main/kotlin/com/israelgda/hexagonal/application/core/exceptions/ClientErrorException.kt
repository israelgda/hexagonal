package com.israelgda.hexagonal.application.core.exceptions

class ClientErrorException(
    message: String,
): RuntimeException(message) {
}