package com.cheesecake.domain.entity

data class VenueEntity(
    val name: String,
    val address: String,
    val city: String,
    val country: String,
    val capacity: Int,
    val surface: String,
    val image: String
)
