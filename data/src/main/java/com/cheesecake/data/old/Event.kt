package com.cheesecake.data.old

import com.google.gson.annotations.SerializedName

data class Event(
    @SerializedName("assist")
    val assist: Assist? = Assist(),
    @SerializedName("comments")
    val comments: Any? = Any(),
    @SerializedName("detail")
    val detail: String? = "",
    @SerializedName("player")
    val player: Player? = Player(),
    @SerializedName("team")
    val team: Team? = Team(),
    @SerializedName("time")
    val time: Time? = Time(),
    @SerializedName("type")
    val type: String? = ""
) {
    data class Assist(
        @SerializedName("id")
        val id: Int? = 0,
        @SerializedName("name")
        val name: String? = ""
    )

    data class Player(
        @SerializedName("id")
        val id: Int? = 0,
        @SerializedName("name")
        val name: String? = ""
    )

    data class Team(
        @SerializedName("id")
        val id: Int? = 0,
        @SerializedName("logo")
        val logo: String? = "",
        @SerializedName("name")
        val name: String? = ""
    )

    data class Time(
        @SerializedName("elapsed")
        val elapsed: Int? = 0,
        @SerializedName("extra")
        val extra: Any? = Any()
    )
}