package com.cheesecake.data.local.converter

import androidx.room.TypeConverter
import com.cheesecake.domain.entity.RecentSearchType

class SearchResultTypeConverter {
    @TypeConverter
    fun fromSearchResultType(type: RecentSearchType) = type.name

    @TypeConverter
    fun toSearchResultType(typeName: String) = RecentSearchType.valueOf(typeName)
}

