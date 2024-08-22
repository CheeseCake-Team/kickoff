package com.cheesecake.presentation.screens.settings

sealed class SettingsEvent {
    object OnSeasonClicked: SettingsEvent()
    object OnTimezoneClicked: SettingsEvent()
}