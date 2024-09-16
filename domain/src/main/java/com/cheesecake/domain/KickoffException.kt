package com.cheesecake.domain

sealed class KickoffException(message: String) : Exception(message) {
    class NoDataFoundException : KickoffException("No data found")
    class TimeoutException : KickoffException("Timeout occurred")
    class NoInternetConnectionException : KickoffException("No internet connection")
    class InternalServerErrorException : KickoffException("Internal server error")
    class NullPointerOccur: KickoffException("Null Pointer")
    class DomainNotAllowedException(message: String) : KickoffException(message)
    class IpNotAllowedException(message: String) : KickoffException(message)
    class RateLimitExceededMinuteException(message: String) : KickoffException(message)
    class RateLimitExceededDayException(message: String) : KickoffException(message)
    class ShortSearchQueryException(message: String) : KickoffException(message)
    class UnknownErrorException(message: String) : KickoffException(message)
}