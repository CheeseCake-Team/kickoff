package com.cheesecake.data.models.base

import com.google.gson.annotations.SerializedName

data class BaseCards(
    @SerializedName("0-15") val zeroToFifteen: MinuteCards,
    @SerializedName("16-30") val sixteenToThirty: MinuteCards,
    @SerializedName("31-45") val thirtyOneToFortyFive: MinuteCards,
    @SerializedName("46-60") val fortySixToSixty: MinuteCards,
    @SerializedName("61-75") val sixtyOneToSeventyFive: MinuteCards,
    @SerializedName("76-90") val seventySixToNinety: MinuteCards,
    @SerializedName("91-105") val ninetyOneToOneHundredFive: MinuteCards?,
    @SerializedName("106-120") val oneHundredSixToOneHundredTwenty: MinuteCards?
)
