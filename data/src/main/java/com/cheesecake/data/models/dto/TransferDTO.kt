package com.cheesecake.data.models.dto


import com.cheesecake.data.models.base.PlayerMeta
import com.cheesecake.data.models.base.TeamTransfer
import com.google.gson.annotations.SerializedName

data class TransferDTO(
    @SerializedName("player")
    val player: PlayerMeta,
    @SerializedName("update")
    val update: String,
    @SerializedName("transfers")
    val transfers: List<Transfer>
) {
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
            val inX: TeamTransfer,
            @SerializedName("out")
            val `out`: TeamTransfer
        )
    }
}