package com.cheesecake.data.remote.models

import com.google.gson.annotations.SerializedName

data class BaseCardsDTO(
    @SerializedName("0-15") val zeroToFifteen: com.cheesecake.data.remote.models.MinuteCardsDTO,
    @SerializedName("16-30") val sixteenToThirty: com.cheesecake.data.remote.models.MinuteCardsDTO,
    @SerializedName("31-45") val thirtyOneToFortyFive: com.cheesecake.data.remote.models.MinuteCardsDTO,
    @SerializedName("46-60") val fortySixToSixty: com.cheesecake.data.remote.models.MinuteCardsDTO,
    @SerializedName("61-75") val sixtyOneToSeventyFive: com.cheesecake.data.remote.models.MinuteCardsDTO,
    @SerializedName("76-90") val seventySixToNinety: com.cheesecake.data.remote.models.MinuteCardsDTO,
    @SerializedName("91-105") val ninetyOneToOneHundredFive: com.cheesecake.data.remote.models.MinuteCardsDTO?,
    @SerializedName("106-120") val oneHundredSixToOneHundredTwenty: com.cheesecake.data.remote.models.MinuteCardsDTO?
)
