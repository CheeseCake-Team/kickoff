package com.cheesecake.data.remote.deserializers

import com.cheesecake.data.remote.models.TeamStatisticsDTO
import com.cheesecake.data.remote.response.BasePagingForStaticResponse
import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import java.lang.reflect.Type

class TeamStatisticsBaseResponseDeserializer() :
    JsonDeserializer<BasePagingForStaticResponse<TeamStatisticsDTO>> {
    override fun deserialize(
        json: JsonElement,
        typeOfT: Type,
        context: JsonDeserializationContext
    ): BasePagingForStaticResponse<TeamStatisticsDTO> {
        val jsonObject = json.asJsonObject

        val errorsElement = jsonObject.get("errors")
        val errors = ErrorsDeserializer().deserialize(errorsElement, typeOfT, context)

        val paging = context.deserialize<BasePagingForStaticResponse.Paging>(
            jsonObject.getAsJsonObject("paging"),
            BasePagingForStaticResponse.Paging::class.java
        )

        val responseElement = jsonObject.get("response")
        val response = if (responseElement != null && responseElement.isJsonObject) {
            context.deserialize<TeamStatisticsDTO>(
                responseElement.asJsonObject,
                TeamStatisticsDTO::class.java
            )
        } else {
            null
        }

        return BasePagingForStaticResponse(errors = errors, paging = paging, response = response)
    }
}