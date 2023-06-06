package com.cheesecake.domain.models

data class Venue(
    val name: String,
    val address: String,
    val city: String,
    val country: String,
    val capacity: Int,
    val surface: String,
    val image: String
)
