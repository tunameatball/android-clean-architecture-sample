package com.kkh.data.di.manager.remote

import com.kkh.data.util.const.API_GET_LOCATION
import retrofit2.Call
import retrofit2.awaitResponse

suspend fun <T : Any> request(
    api: Int,
    call: Call<T>
): T? {
    val networkCall = getApiCall(api, call)

    val response = networkCall?.awaitResponse()
    val result: T? = when (val networkResponse = response?.body()) {
        is NetworkResponse.Success -> {
            networkResponse.body
        }

        is NetworkResponse.Failure -> {
            null
        }

        else -> {
            null
        }
    }

    return result
}

fun <T : Any> getApiCall(api: Int, call: Call<T>): NetworkCall<T>? {
    return when (api) {
        API_GET_LOCATION -> {
            NetworkCall(call = call, apiInfo = APIInfo(api = api))
        }

        else -> {
            null
        }
    }
}