package com.cheesecake.data.models


import com.google.gson.annotations.SerializedName

data class SingleLineupResponse(
    @SerializedName("team")
    val team: Team,
    @SerializedName("coach")
    val coach: Coach,
    @SerializedName("formation")
    val formation: String,
    @SerializedName("startXI")
    val startXI: List<StartXI>,
    @SerializedName("substitutes")
    val substitutes: List<Substitute>
) {
    data class Team(
        @SerializedName("id")
        val id: Int,
        @SerializedName("name")
        val name: String,
        @SerializedName("logo")
        val logo: String,
        @SerializedName("colors")
        val colors: Colors
    ) {
        data class Colors(
            @SerializedName("player")
            val player: Player,
            @SerializedName("goalkeeper")
            val goalkeeper: Goalkeeper
        ) {
            data class Player(
                @SerializedName("primary")
                val primary: String,
                @SerializedName("number")
                val number: String,
                @SerializedName("border")
                val border: String
            )

            data class Goalkeeper(
                @SerializedName("primary")
                val primary: String,
                @SerializedName("number")
                val number: String,
                @SerializedName("border")
                val border: String
            )
        }
    }

    data class Coach(
        @SerializedName("id")
        val id: Int,
        @SerializedName("name")
        val name: String,
        @SerializedName("photo")
        val photo: String
    )

    data class StartXI(
        @SerializedName("player")
        val player: Player
    ) {
        data class Player(
            @SerializedName("id")
            val id: Int,
            @SerializedName("name")
            val name: String,
            @SerializedName("number")
            val number: Int,
            @SerializedName("pos")
            val pos: String,
            @SerializedName("grid")
            val grid: String
        )
    }

    data class Substitute(
        @SerializedName("player")
        val player: Player
    ) {
        data class Player(
            @SerializedName("id")
            val id: Int,
            @SerializedName("name")
            val name: String,
            @SerializedName("number")
            val number: Int,
            @SerializedName("pos")
            val pos: String,
            @SerializedName("grid")
            val grid: Any
        )
    }
}