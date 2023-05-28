package com.cheesecake.data.old

import com.google.gson.annotations.SerializedName

data class Fixtures(
    @SerializedName("events")
    val events: List<Event?>? = listOf(),
    @SerializedName("fixture")
    val fixture: Fixture? = Fixture(),
    @SerializedName("goals")
    val goals: Goals? = Goals(),
    @SerializedName("league")
    val league: League? = League(),
    @SerializedName("score")
    val score: Score? = Score(),
    @SerializedName("teams")
    val teams: Teams? = Teams()
) {

    data class League(
        @SerializedName("country")
        val country: String? = "",
        @SerializedName("flag")
        val flag: String? = "",
        @SerializedName("id")
        val id: Int? = 0,
        @SerializedName("logo")
        val logo: String? = "",
        @SerializedName("name")
        val name: String? = "",
        @SerializedName("round")
        val round: String? = "",
        @SerializedName("season")
        val season: Int? = 0
    )




}