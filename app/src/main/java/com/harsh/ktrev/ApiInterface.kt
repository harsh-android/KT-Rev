package com.harsh.ktrev

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {

    @GET("movie/now_playing")
    fun getPlayingMovie(@Query("api_key") api_key:String) : Call<LatestMovieData>

}