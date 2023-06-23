package com.cheesecake.presentation.models

open class Event<out T>(private val content: T? = null) {

    private var hasBeenHandled = false
        private set

    fun getContentIfNotHandled(): T? {
        return if (hasBeenHandled) {
            null
        } else {
            hasBeenHandled = true
            content
        }
    }
}














