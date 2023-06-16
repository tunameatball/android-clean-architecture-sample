package com.kkh.data.di.manager.remote

import com.google.gson.JsonObject
import java.io.IOException

sealed class NetworkResponse<out T : Any>(
    open val apiInfo: APIInfo,
    open val body: T? = null
) {
    data class Success<T : Any>(override val apiInfo: APIInfo, override val body: T? = null) :
        NetworkResponse<T>(apiInfo, body)

    data class Failure(override val apiInfo: APIInfo, val code: Int, val error: String) :
        NetworkResponse<Nothing>(apiInfo)

    data class ReturnError(override val apiInfo: APIInfo) : NetworkResponse<Nothing>(apiInfo)

    data class ResultError(override val apiInfo: APIInfo, val errorBody: String?) :
        NetworkResponse<Nothing>(apiInfo)

    data class NetworkError(override val apiInfo: APIInfo, val error: IOException) :
        NetworkResponse<Nothing>(apiInfo)

    data class Unexpected(override val apiInfo: APIInfo, val t: Throwable) :
        NetworkResponse<Nothing>(apiInfo)
}

data class APIInfo(
    val api: Int,
    val jsonObject: JsonObject,
    val string: String?,
    val uri: String? = null
)