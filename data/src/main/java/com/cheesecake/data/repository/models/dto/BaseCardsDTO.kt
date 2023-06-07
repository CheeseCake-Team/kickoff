package com.cheesecake.data.repository.models.dto

import com.google.gson.annotations.SerializedName

data class BaseCardsDTO(
    @SerializedName("0-15") val zeroToFifteen: MinuteCardsDTO,
    @SerializedName("16-30") val sixteenToThirty: MinuteCardsDTO,
    @SerializedName("31-45") val thirtyOneToFortyFive: MinuteCardsDTO,
    @SerializedName("46-60") val fortySixToSixty: MinuteCardsDTO,
    @SerializedName("61-75") val sixtyOneToSeventyFive: MinuteCardsDTO,
    @SerializedName("76-90") val seventySixToNinety: MinuteCardsDTO,
    @SerializedName("91-105") val ninetyOneToOneHundredFive: MinuteCardsDTO?,
    @SerializedName("106-120") val oneHundredSixToOneHundredTwenty: MinuteCardsDTO?
)
