package com.cheesecake.data.remote

import com.google.gson.*
import java.lang.reflect.Type

class ErrorsDeserializer : JsonDeserializer<List<String>> {
    override fun deserialize(json: JsonElement?, typeOfT: Type?, context: JsonDeserializationContext?): List<String> {
        if (json == null) {
            return emptyList()
        }
        return if (json.isJsonArray) {
            val jsonArray = json.asJsonArray
            jsonArray.map { it.asString }
        } else if (json.isJsonObject) {
            val jsonObject = json.asJsonObject
            jsonObject.entrySet().map { it.value.asString }
        } else {
            listOf(json.asString)
        }
    }
}
