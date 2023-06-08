package com.cheesecake.data.remote.utils

enum class LeagueType {
    LEAGUE,CUP;

    override fun toString(): String {
        return when (this) {
            LEAGUE -> "league"
            CUP -> "cup"

        }
    }
}