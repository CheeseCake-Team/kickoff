package com.cheesecake.data.models

import com.google.gson.annotations.SerializedName

data class CoachResponse(
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("firstname")
    val firstname: String,
    @SerializedName("lastname")
    val lastname: String,
    @SerializedName("age")
    val age: Int,
    @SerializedName("birth")
    val birth: Birth,
    @SerializedName("nationality")
    val nationality: String,
    @SerializedName("height")
    val height: String,
    @SerializedName("weight")
    val weight: String,
    @SerializedName("photo")
    val photo: String,
    @SerializedName("team")
    val team: Team,
    @SerializedName("career")
    val career: List<Career>
) {
    data class Birth(
        @SerializedName("date")
        val date: String,
        @SerializedName("place")
        val place: String,
        @SerializedName("country")
        val country: String
    )

    data class Team(
        @SerializedName("id")
        val id: Int,
        @SerializedName("name")
        val name: String,
        @SerializedName("logo")
        val logo: String
    )

    data class Career(
        @SerializedName("team")
        val team: Team,
        @SerializedName("start")
        val start: String,
        @SerializedName("end")
        val end: String
    ) {
        data class Team(
            @SerializedName("id")
            val id: Int,
            @SerializedName("name")
            val name: String,
            @SerializedName("logo")
            val logo: String
        )
    }
}