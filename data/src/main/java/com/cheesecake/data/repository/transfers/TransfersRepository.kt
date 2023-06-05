package com.cheesecake.data.repository.transfers

import com.cheesecake.data.models.base.BaseResponse
import com.cheesecake.data.models.dto.TransferDTO
import com.cheesecake.data.remote.RemoteDataSource
import retrofit2.Response
import javax.inject.Inject

class TransfersRepository @Inject constructor(private val remoteDataSource: RemoteDataSource) {

    suspend fun getTransfersByPlayerId(playerId: Int): List<TransferDTO> {
        return remoteDataSource.getTransfersByPlayerId(playerId)
    }

    suspend fun getTransfersByTeamId(teamId: Int): List<TransferDTO> {
        return remoteDataSource.getTransfersByTeamId(teamId)
    }
}