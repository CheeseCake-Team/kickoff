package com.cheesecake.data.repository.timezone

import com.cheesecake.data.models.base.BaseResponse
import retrofit2.Response
import javax.inject.Inject

class TimeZoneRepository @Inject constructor (private val timeZoneApiService: ITimeZoneApiService) {
    suspend fun getTimezoneList(): Response<BaseResponse<String>> {
        return timeZoneApiService.getTimezoneList()
    }
}