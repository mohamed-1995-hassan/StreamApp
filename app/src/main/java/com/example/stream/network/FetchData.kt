package com.example.videostreaming.network

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class FetchData {

    object Service{
        private val client = OkHttpClient.Builder().build()
        private  val retrofit= Retrofit.Builder()
            .baseUrl("https://www.googleapis.com/youtube/v3/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()

        fun<T> buildService(service:Class<T>):T{
            return retrofit.create(service)
        }
    }
}