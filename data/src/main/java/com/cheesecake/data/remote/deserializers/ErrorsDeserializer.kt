package com.cheesecake.data.remote.deserializers

import com.cheesecake.data.remote.response.Error
import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import java.lang.reflect.Type

class ErrorsDeserializer : JsonDeserializer<Error> {
    override fun deserialize(
        json: JsonElement?,
        typeOfT: Type?,
        context: JsonDeserializationContext?
    ): Error? {
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

            val search = if (jsonObject.has("search") && !jsonObject.get("search").isJsonNull) {
                jsonObject.get("search").asString
            } else {
                null
            }

            val requests =
                if (jsonObject.has("requests") && !jsonObject.get("requests").isJsonNull) {
                    jsonObject.get("requests").asString
                } else {
                    null
                }

            return Error(rateLimit = rateLimit, ip = ip, search = search, requests = requests)
        }

        return null
    }
}