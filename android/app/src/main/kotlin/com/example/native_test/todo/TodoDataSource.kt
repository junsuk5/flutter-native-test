package com.example.native_test.todo

import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.create
import retrofit2.http.GET
import retrofit2.http.Path

interface TodoDataSource {

    @GET("/todos/{id}")
    suspend fun getTodo(@Path("id") id: Int): Response<String>

    companion object {
        fun instance(): TodoDataSource {
            return Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com")
                .addConverterFactory(ScalarsConverterFactory.create())
                .build()
                .create()
        }
    }
}