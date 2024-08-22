package com.cheesecake.domain.usecases

import com.cheesecake.domain.repository.IFootballRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ManageTimezoneUseCase @Inject constructor(
    private val repository: IFootballRepository
) {
    suspend fun getTimezones(): List<String> {
        return repository.getTimezones()
    }

    fun getTimezone(): Flow<String> {
        return repository.getTimezone()
    }

    suspend fun setTimezone(timezone: String): String {
        repository.setTimezone(timezone)
        return timezone
    }
}