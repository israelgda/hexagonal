package com.israelgda.hexagonal.application.core.exceptions.responses

data class StandardError(
    val status: Int,
    val error: String,
    val message: String,
)
