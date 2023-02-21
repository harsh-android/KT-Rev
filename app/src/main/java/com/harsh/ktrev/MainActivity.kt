package com.harsh.ktrev

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.harsh.ktrev.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private val TAG = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var apiInterface = ApiClient.getApiClient().create(ApiInterface::class.java)

        apiInterface.getPlayingMovie(ApiClient.API_KEY).enqueue(object : Callback<LatestMovieData> {
            override fun onResponse(
                call: Call<LatestMovieData>,
                response: Response<LatestMovieData>
            ) {
                if (response.isSuccessful) {
                    Log.e(TAG, "onResponse: ============ " )
                } else {
                    Log.e(TAG, "onResponse: ???????????? "+response.message() )
                }
            }

            override fun onFailure(call: Call<LatestMovieData>, t: Throwable) {
                Log.e(TAG, "onFailure: ----------- "+t.message )
            }

        })

    }
}