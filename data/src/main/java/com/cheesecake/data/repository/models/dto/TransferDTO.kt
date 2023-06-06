package com.cheesecake.data.repository.models.dto


import com.cheesecake.data.repository.models.base.PlayerMeta
import com.cheesecake.data.repository.models.base.TeamTransfer
import com.google.gson.annotations.SerializedName

data class TransferDTO(
    @SerializedName("player")
    val player: com.cheesecake.data.repository.models.base.PlayerMeta,
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
            val inX: com.cheesecake.data.repository.models.base.TeamTransfer,
            @SerializedName("out")
            val `out`: com.cheesecake.data.repository.models.base.TeamTransfer
        )
    }
}