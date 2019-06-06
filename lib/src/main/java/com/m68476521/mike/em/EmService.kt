package com.m68476521.mike.em

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.m68476521.mike.em_lib.BuildConfig
import io.reactivex.Single
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface EmService {
    companion object {
        fun create(url: String, apiKey: String, hash: String): EmService {
            val builder = Retrofit.Builder()
                .client(createClient(apiKey = apiKey, hash = hash))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(dateFormatter()))
                .baseUrl(url)
                .build()
            return builder.create(EmService::class.java)
        }

        private fun createClient(apiKey: String, hash: String): OkHttpClient {
            return OkHttpClient.Builder()
                .addInterceptor(RequestInterceptor(apiKey = apiKey, hash = hash))
                .addInterceptor(HttpLoggingInterceptor().apply {
                    level = if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY else HttpLoggingInterceptor.Level.NONE
                })
                .build()
        }

        private fun dateFormatter(): Gson {
            return GsonBuilder()
                .setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ")
                .create()
        }
    }

    @GET("v1/public/characters")
    fun getPublicCharacters(@Query("limit") limit: Int): Single<Character>

    @GET("v1/public/characters/{characterId}")
    fun getCharacterById(@Path("characterId") limit: Int): Single<Character>
}
