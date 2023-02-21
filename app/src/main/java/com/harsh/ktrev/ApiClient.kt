package com.harsh.ktrev

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiClient {

    companion object {

        val BASE_URL = "https://api.themoviedb.org/3/"
        val API_KEY = "6a99b6d071f902670afad5e3effd2fb6"
        lateinit var retrofit:Retrofit

        fun getApiClient(): Retrofit {

            retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            return retrofit
        }

    }

}