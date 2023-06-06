package com.cheesecake.data.repository.models.dto

import com.cheesecake.data.repository.models.base.BaseBirth
import com.cheesecake.data.repository.models.base.Team
import com.google.gson.annotations.SerializedName

data class CoachDTO(
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("firstname")
    val firstname: String,
    @SerializedName("lastname")
    val lastname: String,
    @SerializedName("age")
    val age: Int,
    @SerializedName("birth")
    val birth: com.cheesecake.data.repository.models.base.BaseBirth,
    @SerializedName("nationality")
    val nationality: String,
    @SerializedName("height")
    val height: String,
    @SerializedName("weight")
    val weight: String,
    @SerializedName("photo")
    val photo: String,
    @SerializedName("team")
    val team: com.cheesecake.data.repository.models.base.Team,
    @SerializedName("career")
    val career: List<com.cheesecake.data.repository.models.dto.CoachDTO.Career>
) {
    data class Career(
        @SerializedName("team")
        val team: com.cheesecake.data.repository.models.base.Team,
        @SerializedName("start")
        val start: String,
        @SerializedName("end")
        val end: String
    )
}