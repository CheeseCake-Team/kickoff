package com.cheesecake.data.models


import com.google.gson.annotations.SerializedName

data class SingleInjuriesResponse(
    @SerializedName("player")
    val player: Player,
    @SerializedName("team")
    val team: Team,
    @SerializedName("fixture")
    val fixture: Fixture,
    @SerializedName("league")
    val league: League
) {
    data class Player(
        @SerializedName("id")
        val id: Int,
        @SerializedName("name")
        val name: String,
        @SerializedName("photo")
        val photo: String,
        @SerializedName("type")
        val type: String,
        @SerializedName("reason")
        val reason: String
    )

    data class Team(
        @SerializedName("id")
        val id: Int,
        @SerializedName("name")
        val name: String,
        @SerializedName("logo")
        val logo: String
    )

    data class Fixture(
        @SerializedName("id")
        val id: Int,
        @SerializedName("timezone")
        val timezone: String,
        @SerializedName("date")
        val date: String,
        @SerializedName("timestamp")
        val timestamp: Int
    )

    data class League(
        @SerializedName("id")
        val id: Int,
        @SerializedName("season")
        val season: Int,
        @SerializedName("name")
        val name: String,
        @SerializedName("country")
        val country: String,
        @SerializedName("logo")
        val logo: String,
        @SerializedName("flag")
        val flag: String
    )
}