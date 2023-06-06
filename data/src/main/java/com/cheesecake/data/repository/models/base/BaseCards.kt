package com.cheesecake.data.repository.models.base

import com.google.gson.annotations.SerializedName

data class BaseCards(
    @SerializedName("0-15") val zeroToFifteen: com.cheesecake.data.repository.models.base.MinuteCards,
    @SerializedName("16-30") val sixteenToThirty: com.cheesecake.data.repository.models.base.MinuteCards,
    @SerializedName("31-45") val thirtyOneToFortyFive: com.cheesecake.data.repository.models.base.MinuteCards,
    @SerializedName("46-60") val fortySixToSixty: com.cheesecake.data.repository.models.base.MinuteCards,
    @SerializedName("61-75") val sixtyOneToSeventyFive: com.cheesecake.data.repository.models.base.MinuteCards,
    @SerializedName("76-90") val seventySixToNinety: com.cheesecake.data.repository.models.base.MinuteCards,
    @SerializedName("91-105") val ninetyOneToOneHundredFive: com.cheesecake.data.repository.models.base.MinuteCards?,
    @SerializedName("106-120") val oneHundredSixToOneHundredTwenty: com.cheesecake.data.repository.models.base.MinuteCards?
)
