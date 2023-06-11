package com.kkh.data.di.manager.remote

import android.content.Context
import com.kkh.data.R
import okhttp3.Interceptor
import okhttp3.Response

class AppInterceptor(private val context: Context) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val clientId = context.getString(R.string.naver_developer_id)
        val clientSecret = context.getString(R.string.naver_developer_secret)

        val newRequest = chain.request().newBuilder()
            .addHeader("X-Naver-Client-Id", clientId)
            .addHeader("X-Naver-Client-Secret", clientSecret)
            .build()

        return chain.proceed(newRequest)
    }
}