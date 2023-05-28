package com.cheesecake.kickoff.old

import com.google.gson.annotations.SerializedName

data class Coverage(
    @SerializedName("fixtures")
    val fixtures: Fixtures,
    @SerializedName("standings")
    val standings: Boolean,
    @SerializedName("players")
    val players: Boolean,
    @SerializedName("top_scorers")
    val topScorers: Boolean,
    @SerializedName("top_assists")
    val topAssists: Boolean,
    @SerializedName("top_cards")
    val topCards: Boolean,
    @SerializedName("injuries")
    val injuries: Boolean,
    @SerializedName("predictions")
    val predictions: Boolean,
    @SerializedName("odds")
    val odds: Boolean
)