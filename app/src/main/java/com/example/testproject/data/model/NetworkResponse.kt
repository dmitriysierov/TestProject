package com.example.testproject.data.model

import com.example.testproject.data.model.response.PostResponse

sealed class NetworkResponse<out T> {
    data class Success<out T : Any>(val data: PostResponse?) : NetworkResponse<T>()
    data class Error(val message: String) : NetworkResponse<Nothing>()
    data class Failure(val exception: Throwable) : NetworkResponse<Nothing>()
    data class Loading(val state: Boolean) : NetworkResponse<Nothing>()
}
