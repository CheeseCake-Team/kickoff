package com.cheesecake.data.repository.timezone

import com.cheesecake.data.models.base.BaseResponse
import com.cheesecake.data.remote.RemoteDataSource
import retrofit2.Response
import javax.inject.Inject

class TimeZoneRepository @Inject constructor (private val remoteDataSource: RemoteDataSource) {
    suspend fun getTimezoneList(): List<String> {
        return remoteDataSource.getTimezoneList()
    }
}