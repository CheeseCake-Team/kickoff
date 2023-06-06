package com.cheesecake.data.repository.models.response


import com.cheesecake.data.repository.models.dto.PlayerMetaDTO
import com.cheesecake.data.repository.models.dto.TeamTransferDTO
import com.google.gson.annotations.SerializedName

data class TransferResponse(
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