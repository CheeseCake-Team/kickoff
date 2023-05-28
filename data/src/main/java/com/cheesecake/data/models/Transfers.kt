package com.cheesecake.data.models


import com.google.gson.annotations.SerializedName

data class Transfers(
    @SerializedName("errors")
    val errors: List<Any?>? = listOf(),
    @SerializedName("get")
    val `get`: String? = "",
    @SerializedName("paging")
    val paging: Paging? = Paging(),
    @SerializedName("parameters")
    val parameters: Parameters? = Parameters(),
    @SerializedName("response")
    val response: List<Response?>? = listOf(),
    @SerializedName("results")
    val results: Int? = 0
) {
    data class Paging(
        @SerializedName("current")
        val current: Int? = 0,
        @SerializedName("total")
        val total: Int? = 0
    )

    data class Parameters(
        @SerializedName("player")
        val player: String? = ""
    )

    data class Response(
        @SerializedName("player")
        val player: Player? = Player(),
        @SerializedName("transfers")
        val transfers: List<Transfer?>? = listOf(),
        @SerializedName("update")
        val update: String? = ""
    ) {
        data class Player(
            @SerializedName("id")
            val id: Int? = 0,
            @SerializedName("name")
            val name: String? = ""
        )

        data class Transfer(
            @SerializedName("date")
            val date: String? = "",
            @SerializedName("teams")
            val teams: Teams? = Teams(),
            @SerializedName("type")
            val type: String? = ""
        ) {
            data class Teams(
                @SerializedName("in")
                val inX: In? = In(),
                @SerializedName("out")
                val `out`: Out? = Out()
            ) {
                data class In(
                    @SerializedName("id")
                    val id: Int? = 0,
                    @SerializedName("logo")
                    val logo: String? = "",
                    @SerializedName("name")
                    val name: String? = ""
                )

                data class Out(
                    @SerializedName("id")
                    val id: Int? = 0,
                    @SerializedName("logo")
                    val logo: String? = "",
                    @SerializedName("name")
                    val name: String? = ""
                )
            }
        }
    }
}