package com.cheesecake.data.remote.transfers

import com.cheesecake.data.models.base.BaseResponse
import com.cheesecake.data.models.dto.TransferDTO
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ITransferApiService {

    @GET("transfers")
    suspend fun getTransfersByPlayerId(
        @Query("id") playerId: Int
    ): Response<BaseResponse<TransferDTO>>

    @GET("transfers")
    suspend fun getTransfersByTeamId(
        @Query("team") teamId: Int
    ): Response<BaseResponse<TransferDTO>>

}