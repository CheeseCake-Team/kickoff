package com.cheesecake.domain.entity

data class PlayerStatistics(
    val id: Int,
    val name: String,
    val teamName: String,
    val competitionCountry: String,
    val firstname: String,
    val lastname: String,
    val age: Int,
    val birthDate: String,
    val birthPlace: String?,
    val birthCountry: String,
    val nationality: String,
    val heightInCm: String,
    val weightInKg: String,
    val isInjured: Boolean,
    val imageUrl: String,
    val appearances: Int,
    val lineups: Int,
    val minutes: Int,
    val number: Int,
    val position: String,
    val rating: String,
    val isCaptain: Boolean,
    val goals: Int
)