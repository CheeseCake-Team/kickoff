package com.cheesecake.data.local.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity("Country_table")
data class CountryLocalDto(
    @PrimaryKey val countryId: Int,
    val name: String,
    val flagImageUrl: String,
)