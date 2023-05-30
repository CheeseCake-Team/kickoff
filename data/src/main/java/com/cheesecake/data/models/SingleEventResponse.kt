package com.cheesecake.data.models


import com.google.gson.annotations.SerializedName

data class SingleEventResponse(
    @SerializedName("time")
    val time: Time,
    @SerializedName("team")
    val team: Team,
    @SerializedName("player")
    val player: Player,
    @SerializedName("assist")
    val assist: Assist,
    @SerializedName("type")
    val type: String,
    @SerializedName("detail")
    val detail: String,
    @SerializedName("comments")
    val comments: String
) {
    data class Time(
        @SerializedName("elapsed")
        val elapsed: Int,
        @SerializedName("extra")
        val extra: Any
    )

    data class Team(
        @SerializedName("id")
        val id: Int,
        @SerializedName("name")
        val name: String,
        @SerializedName("logo")
        val logo: String
    )

    data class Player(
        @SerializedName("id")
        val id: Int,
        @SerializedName("name")
        val name: String
    )

    data class Assist(
        @SerializedName("id")
        val id: Any,
        @SerializedName("name")
        val name: Any
    )
}