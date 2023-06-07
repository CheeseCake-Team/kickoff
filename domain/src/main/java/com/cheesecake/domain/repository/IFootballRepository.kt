package com.cheesecake.domain.repository

import com.cheesecake.domain.entity.PlayerEntity

interface IFootballRepository {
    suspend fun getSinglePlayerCompact(season: String, teamId: Int):List<PlayerEntity>
}