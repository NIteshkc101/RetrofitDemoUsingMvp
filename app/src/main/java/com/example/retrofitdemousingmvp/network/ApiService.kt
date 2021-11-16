package com.example.retrofitdemousingmvp.network


import com.example.retrofitdemousingmvp.Constants
import com.example.retrofitdemousingmvp.loginResponse.LoginResponseData
import com.example.retrofitdemousingmvp.vehicleResponse.VehicleResponseList

import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.*

interface ApiService {


    @GET("/vehicleList")
    fun getVehicleData() : Call<VehicleResponseList>


    @POST(Constants.loginUrl)
    fun login(
        @Body requestBody: RequestBody
    ):Call<LoginResponseData>

}