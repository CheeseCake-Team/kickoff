package com.cheesecake.domain

sealed class KickoffException(message: String) : Exception(message) {
    class NoDataFoundException : KickoffException("No data found")
    class TimeoutException : KickoffException("Timeout occurred")
    class NoInternetConnectionException : KickoffException("No internet connection")
    class InternalServerErrorException : KickoffException("Internal server error")
    class NullPointerOccur: KickoffException("Null Pointer")
}