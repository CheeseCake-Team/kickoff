package com.cheesecake.data.utils

enum class LeagueType {
    LEAGUE,CUP;

    override fun toString(): String {
        return when (this) {
            LEAGUE -> "league"
            CUP -> "cup"

        }
    }
}