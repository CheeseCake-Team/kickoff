package com.cheesecake.domain.entity

data class Team(
    val id: Int,
    val name: String,
    val yearFounded: Int,
    val country: String,
    val stadiumCapacity: Int,
    val stadiumName: String,
    val imageUrl: String,
    val isFavourite: Boolean,
)
