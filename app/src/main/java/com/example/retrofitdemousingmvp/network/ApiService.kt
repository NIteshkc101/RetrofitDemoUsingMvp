package com.example.retrofitdemousingmvp.network


import com.example.retrofitdemousingmvp.Constants
import com.example.retrofitdemousingmvp.loginResponse.LoginResponseData

import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.*

interface ApiService {


    @POST(Constants.loginUrl)
    fun login(
        @Body requestBody: RequestBody
    ):Call<LoginResponseData>

}