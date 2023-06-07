package com.cheesecake.data.repository.models.response

import com.cheesecake.data.repository.models.dto.BaseBirthDTO
import com.cheesecake.data.repository.models.dto.TeamDTO
import com.google.gson.annotations.SerializedName

data class CoachResponse(
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
    val birth: BaseBirthDTO,
    @SerializedName("nationality")
    val nationality: String,
    @SerializedName("height")
    val height: String,
    @SerializedName("weight")
    val weight: String,
    @SerializedName("photo")
    val photo: String,
    @SerializedName("team")
    val team: TeamDTO,
    @SerializedName("career")
    val career: List<Career>
) {
    data class Career(
        @SerializedName("team")
        val team: TeamDTO,
        @SerializedName("start")
        val start: String,
        @SerializedName("end")
        val end: String
    )
}