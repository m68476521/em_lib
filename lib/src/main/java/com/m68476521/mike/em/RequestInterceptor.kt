package com.m68476521.mike.em

import okhttp3.Interceptor
import okhttp3.Response

class RequestInterceptor(
    private val apiKey: String,
    private val hash: String
) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        var request = chain.request()
        val url = request.url().newBuilder()
            .addQueryParameter("ts", "1")
            .addQueryParameter("apikey", apiKey)
            .addQueryParameter("hash", hash)
            .build()

        request = request
            .newBuilder()
            .url(url)
            .build()

        return chain.proceed(request)
    }
}