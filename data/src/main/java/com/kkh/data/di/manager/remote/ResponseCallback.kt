package com.kkh.data.di.manager.remote

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ResponseCallback<T : Any> : Callback<NetworkResponse<T>> {

    val responseCallbacks = mutableListOf<OnNetworkResponse>()

    override fun onResponse(
        call: Call<NetworkResponse<T>>,
        response: Response<NetworkResponse<T>>
    ) {
        
        val result = response.body()
    }

    override fun onFailure(call: Call<NetworkResponse<T>>, t: Throwable) {
        TODO("Not yet implemented")
    }

    inner class OnNetworkResponse {

        fun onNetworkResponse(data: T, apiInfo: APIInfo) {

        }
    }
}