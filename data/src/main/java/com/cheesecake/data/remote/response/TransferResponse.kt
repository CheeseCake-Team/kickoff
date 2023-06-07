package com.cheesecake.data.remote.response


import com.cheesecake.data.remote.models.PlayerMetaDTO
import com.cheesecake.data.remote.models.TeamTransferDTO
import com.google.gson.annotations.SerializedName

data class TransferResponse(
    @SerializedName("player")
    val player: com.cheesecake.data.remote.models.PlayerMetaDTO,
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
            val inX: com.cheesecake.data.remote.models.TeamTransferDTO,
            @SerializedName("out")
            val `out`: com.cheesecake.data.remote.models.TeamTransferDTO
        )
    }
}