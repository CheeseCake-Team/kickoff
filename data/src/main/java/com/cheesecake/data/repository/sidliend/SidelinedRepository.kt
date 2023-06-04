package com.cheesecake.data.repository.sidliend

import com.cheesecake.data.models.base.BaseResponse
import com.cheesecake.data.models.dto.SidelinedDTO
import com.cheesecake.data.remote.RemoteDataSource
import retrofit2.Response
import javax.inject.Inject

class SidelinedRepository @Inject constructor(private val remoteDataSource: RemoteDataSource) {

    suspend fun getPlayerSidelined(playerId: Int): List<SidelinedDTO> {
        return remoteDataSource.getPlayerSidelined(playerId)
    }

    suspend fun getCoachSidelined(coachId: Int): List<SidelinedDTO> {
        return remoteDataSource.getCoachSidelined(coachId)
    }
}