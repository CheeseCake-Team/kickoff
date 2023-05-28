package com.cheesecake.kickoff.models


import com.google.gson.annotations.SerializedName

data class PlayerSquad(
    @SerializedName("errors")
    val errors: List<Any?>? = listOf(),
    @SerializedName("get")
    val `get`: String? = "",
    @SerializedName("paging")
    val paging: Paging? = Paging(),
    @SerializedName("parameters")
    val parameters: Parameters? = Parameters(),
    @SerializedName("response")
    val response: List<Response?>? = listOf(),
    @SerializedName("results")
    val results: Int? = 0
) {
    data class Paging(
        @SerializedName("current")
        val current: Int? = 0,
        @SerializedName("total")
        val total: Int? = 0
    )

    data class Parameters(
        @SerializedName("team")
        val team: String? = ""
    )

    data class Response(
        @SerializedName("players")
        val players: List<Player?>? = listOf(),
        @SerializedName("team")
        val team: Team? = Team()
    ) {
        data class Player(
            @SerializedName("age")
            val age: Int? = 0,
            @SerializedName("id")
            val id: Int? = 0,
            @SerializedName("name")
            val name: String? = "",
            @SerializedName("number")
            val number: Int? = 0,
            @SerializedName("photo")
            val photo: String? = "",
            @SerializedName("position")
            val position: String? = ""
        )

        data class Team(
            @SerializedName("id")
            val id: Int? = 0,
            @SerializedName("logo")
            val logo: String? = "",
            @SerializedName("name")
            val name: String? = ""
        )
    }
}