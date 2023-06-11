package com.kkh.data.di.manager.remote

import com.kkh.data.util.const.NETWORK_RSPN_200
import com.kkh.data.util.const.NETWORK_RSPN_400
import com.kkh.data.util.const.NETWORK_RSPN_402
import com.kkh.data.util.const.NETWORK_RSPN_403
import com.kkh.data.util.const.NETWORK_RSPN_404
import com.kkh.data.util.const.NETWORK_RSPN_409
import com.kkh.data.util.const.NETWORK_RSPN_500
import com.kkh.data.util.const.NETWORK_RSPN_501
import com.kkh.data.util.const.NETWORK_RSPN_502
import com.kkh.data.util.const.NETWORK_RSPN_503
import okhttp3.Request
import okio.Timeout
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.IOException

class NetworkCall<T : Any>(private val call: Call<T>, private val apiInfo: APIInfo) :
    Call<NetworkResponse<T>> {
    override fun enqueue(callback: Callback<NetworkResponse<T>>) {
        call.enqueue(object : Callback<T> {
            override fun onResponse(call: Call<T>, response: Response<T>) {
                when (response.code()) {
                    NETWORK_RSPN_200 -> {
                        if (response.isSuccessful) {
                            callback.onResponse(
                                this@NetworkCall,
                                Response.success(NetworkResponse.Success(apiInfo, response.body()))
                            )
                        } else {
                            callback.onResponse(
                                this@NetworkCall,
                                Response.success(
                                    NetworkResponse.ReturnError(apiInfo)
                                )
                            )
                        }
                    }

                    NETWORK_RSPN_400,
                    NETWORK_RSPN_402,
                    NETWORK_RSPN_403,
                    NETWORK_RSPN_404 -> {
                        callback.onResponse(
                            this@NetworkCall,
                            Response.success(
                                NetworkResponse.ReturnError(apiInfo)
                            )
                        )
                    }

                    NETWORK_RSPN_409 -> {
                        callback.onResponse(
                            this@NetworkCall,
                            Response.success(
                                NetworkResponse.ResultError(
                                    apiInfo,
                                    response.errorBody().toString()
                                )
                            )
                        )
                    }

                    NETWORK_RSPN_500,
                    NETWORK_RSPN_501,
                    NETWORK_RSPN_502,
                    NETWORK_RSPN_503 -> {
                        callback.onResponse(
                            this@NetworkCall,
                            Response.success(
                                NetworkResponse.Failure(
                                    apiInfo,
                                    response.code(),
                                    response.errorBody().toString()
                                )
                            )
                        )
                    }
                }
            }

            override fun onFailure(call: Call<T>, t: Throwable) {
                val response = when (t) {
                    is IOException -> NetworkResponse.NetworkError(apiInfo, t)
                    else -> NetworkResponse.Unexpected(apiInfo, t)
                }
                callback.onResponse(this@NetworkCall, Response.success(response))
            }
        })
    }

    override fun clone(): Call<NetworkResponse<T>> = NetworkCall(call.clone(), apiInfo)

    override fun execute(): Response<NetworkResponse<T>> {
        throw UnsupportedOperationException("unsupported method")
    }

    override fun isExecuted(): Boolean = call.isExecuted

    override fun cancel() = call.cancel()

    override fun isCanceled(): Boolean = call.isCanceled

    override fun request(): Request = call.request()

    override fun timeout(): Timeout {
        return call.timeout()
    }
}