package com.cheesecake.data.repository.transfers

import com.cheesecake.data.models.base.BaseResponse
import com.cheesecake.data.models.dto.TransferDTO
import retrofit2.Response
import javax.inject.Inject

class TransfersRepository @Inject constructor(private val transferApiService: ITransferApiService) {

    suspend fun getTransfersByPlayerId(playerId: Int): Response<BaseResponse<TransferDTO>> {
        return transferApiService.getTransfersByPlayerId(playerId)
    }

    suspend fun getTransfersByTeamId(teamId: Int): Response<BaseResponse<TransferDTO>> {
        return transferApiService.getTransfersByTeamId(teamId)
    }
}