package com.cheesecake.data.local.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.cheesecake.data.local.converter.SearchResultTypeConverter
import com.cheesecake.domain.entity.RecentSearchType

@Entity(tableName = "recentSearch_table")
class RecentSearchLocalDTO(
    @PrimaryKey(autoGenerate = true)
    val rank: Int,
    val id: Int,
    val imageUrl: String,
    val title: String,
    @TypeConverters(SearchResultTypeConverter::class)
    val type: RecentSearchType
)

