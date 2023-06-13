package com.cheesecake.data.remote.models

import com.cheesecake.data.remote.models.*
import com.google.gson.annotations.SerializedName

data class TransferDTO(
    @SerializedName("player")
    val player: PlayerMetaDTO,
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
            val inX: TeamTransferDTO,
            @SerializedName("out")
            val `out`: TeamTransferDTO
        )
    }
}