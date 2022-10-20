package com.example.stree

import retrofit2.Response
import retrofit2.http.GET

interface DataService {

    @GET("/products")
    suspend fun getData():Response<Example>
}