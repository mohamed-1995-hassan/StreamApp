package com.example.stream

import Json4Kotlin_Base
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface VideosComponent {

    @GET("videos")
    fun getmov(@Query("part") part:String, @Query("chart") chart:String,
               @Query("regionCode") regionCode:String, @Query("maxResults") maxResults:String,
               @Query("key") key:String, @Query("fbclid") fbclid:String): Call<Json4Kotlin_Base>

}