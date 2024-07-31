package com.cheesecake.data.remote

import com.cheesecake.data.remote.response.BasePagingResponse
import com.google.gson.*
import java.lang.reflect.Type

class ErrorsDeserializer : JsonDeserializer<BasePagingResponse.Error> {
    override fun deserialize(
        json: JsonElement?,
        typeOfT: Type?,
        context: JsonDeserializationContext?
    ): BasePagingResponse.Error? {
        if (json == null || json.isJsonNull) {
            return null
        }

        if (json.isJsonObject) {
            val jsonObject = json.asJsonObject
            val rateLimit =
                if (jsonObject.has("rateLimit") && !jsonObject.get("rateLimit").isJsonNull) {
                    jsonObject.get("rateLimit").asString
                } else {
                    null
                }
            val ip = if (jsonObject.has("Ip") && !jsonObject.get("Ip").isJsonNull) {
                jsonObject.get("Ip").asString
            } else {
                null
            }
            return BasePagingResponse.Error(rateLimit = rateLimit, ip = ip)
        }

        return null
    }
}