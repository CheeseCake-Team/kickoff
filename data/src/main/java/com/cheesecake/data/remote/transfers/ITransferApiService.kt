package com.cheesecake.data.remote.transfers

import com.cheesecake.data.models.BaseResponse
import com.cheesecake.data.models.SingleTransferResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ITransferApiService {

    @GET("transfers")
    suspend fun getTransfersByPlayerId(
        @Query("id") playerId: Int
    ): Response<BaseResponse<SingleTransferResponse>>

    @GET("transfers")
    suspend fun getTransfersByTeamId(
        @Query("team") teamId: Int
    ): Response<BaseResponse<SingleTransferResponse>>

}