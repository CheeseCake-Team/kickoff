package com.cheesecake.domain.entity


data class RecentSearch(
    val id: Int,
    val imageUrl: String,
    val title: String,
    val type: RecentSearchType
)
enum class RecentSearchType {
    TEAM, LEAGUE
}