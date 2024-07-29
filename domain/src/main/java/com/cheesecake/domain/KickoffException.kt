package com.cheesecake.domain

sealed class KickoffException(message: String) : Exception(message) {
    class NoDataFoundException : KickoffException("No data found")
    class TimeoutException : KickoffException("Timeout occurred")
    class NoInternetConnectionException : KickoffException("No internet connection")
    class InternalServerErrorException : KickoffException("Internal server error")
    class NullPointerOccur: KickoffException("Null Pointer")
    class DomainNotAllowedException(message: String) : Exception(message)
    class IpNotAllowedException(message: String) : Exception(message)
    class RateLimitExceededMinuteException(message: String) : Exception(message)
    class RateLimitExceededDayException(message: String) : Exception(message)
    class UnknownErrorException(message: String) : Exception(message)
}