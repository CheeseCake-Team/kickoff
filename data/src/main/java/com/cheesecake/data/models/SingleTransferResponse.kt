package com.cheesecake.data.models


import com.google.gson.annotations.SerializedName

data class SingleTransferResponse(
    @SerializedName("player")
    val player: Player,
    @SerializedName("update")
    val update: String,
    @SerializedName("transfers")
    val transfers: List<Transfer>
) {
    data class Player(
        @SerializedName("id")
        val id: Int,
        @SerializedName("name")
        val name: String
    )

    data class Transfer(
        @SerializedName("date")
        val date: String,
        @SerializedName("type")
        val type: String,
        @SerializedName("teams")
        val teams: Teams
    ) {
        data class Teams(
            @SerializedName("in")
            val inX: In,
            @SerializedName("out")
            val `out`: Out
        ) {
            data class In(
                @SerializedName("id")
                val id: Int,
                @SerializedName("name")
                val name: String,
                @SerializedName("logo")
                val logo: String
            )

            data class Out(
                @SerializedName("id")
                val id: Int,
                @SerializedName("name")
                val name: String,
                @SerializedName("logo")
                val logo: String
            )
        }
    }
}