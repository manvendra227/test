package com.example.stree

import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory


object RetrofitBuilder {

    private const val baseURL = "https://dummyjson.com"

    private val okHttp = OkHttpClient.Builder()

    private var gson = GsonBuilder()
        .setLenient()
        .create()
    private val builder = Retrofit.Builder().baseUrl(baseURL)
        .addConverterFactory(ScalarsConverterFactory.create())
        .addConverterFactory(GsonConverterFactory.create(gson))
        .client(okHttp.build())

    private val retrofit = builder.build()

    fun <T> buildService(service: Class<T>):T{
        return retrofit.create(service)
    }
}