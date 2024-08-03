package com.cheesecake.data.remote.deserializers

import com.cheesecake.data.remote.response.BasePagingForStaticResponse
import com.cheesecake.data.remote.response.Error
import com.google.gson.JsonArray
import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import com.google.gson.JsonObject
import java.lang.reflect.Type

class BasePagingForStaticResponseDeserializer<T> :
    JsonDeserializer<BasePagingForStaticResponse<T>> {
    override fun deserialize(
        json: JsonElement,
        typeOfT: Type,
        context: JsonDeserializationContext
    ): BasePagingForStaticResponse<T> {
        val jsonObject = json.asJsonObject

        val errorsElement = jsonObject.get("errors")
        val errors = ErrorsDeserializer().deserialize(errorsElement, typeOfT, context)

        val paging = context.deserialize<BasePagingForStaticResponse.Paging>(
            jsonObject.get("paging"),
            BasePagingForStaticResponse.Paging::class.java
        )

        val response = when (val responseElement = jsonObject.get("response")) {
            is JsonObject -> context.deserialize(responseElement, typeOfT)
            else -> null // Handle other unexpected types
        }

        return BasePagingForStaticResponse(errors = errors, paging = paging, response = response)
    }
}