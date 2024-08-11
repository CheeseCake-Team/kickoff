package com.cheesecake.data.remote.response

import com.cheesecake.data.remote.utils.ErrorType
import com.google.gson.annotations.SerializedName

data class Error(
    @SerializedName("rateLimit")
    val rateLimit: String?,
    @SerializedName("Ip")
    val ip: String?,
    @SerializedName("search")
    val search: String?
) {
    fun getErrorType(): ErrorType {
        return when {
            ip == ErrorType.DOMAIN_NOT_ALLOWED.message -> ErrorType.DOMAIN_NOT_ALLOWED
            ip == ErrorType.IP_NOT_ALLOWED.message -> ErrorType.IP_NOT_ALLOWED
            rateLimit == ErrorType.RATE_LIMIT_EXCEEDED_MINUTE.message -> ErrorType.RATE_LIMIT_EXCEEDED_MINUTE
            rateLimit == ErrorType.RATE_LIMIT_EXCEEDED_DAY.message -> ErrorType.RATE_LIMIT_EXCEEDED_DAY
            search == ErrorType.SHORT_SEARCH_QUERY.message -> ErrorType.SHORT_SEARCH_QUERY
            else -> ErrorType.UNKNOWN_ERROR
        }
    }
}