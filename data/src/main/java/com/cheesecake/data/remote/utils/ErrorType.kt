package com.cheesecake.data.remote.utils

enum class ErrorType(val message: String) {
    DOMAIN_NOT_ALLOWED("This Domain is not allowed to call the API, check the list of allowed Domains in the dashboard."),
    IP_NOT_ALLOWED("This IP is not allowed to call the API, check the list of allowed IPs in the dashboard."),
    RATE_LIMIT_EXCEEDED_MINUTE("Too many requests. Your rate limit is 10 requests per minute."),
    RATE_LIMIT_EXCEEDED_DAY("You have reached the request limit for the day, Go to https://dashboard.api-football.com to upgrade your plan."),
    SHORT_SEARCH_QUERY("The Search field must be at least 3 characters in length."),
    UNKNOWN_ERROR("An unknown error occurred.")
}