package com.example.retrofitget

import android.util.Log
import com.example.retrofitdemousingmvp.loginResponse.ApiResponse
import com.example.retrofitdemousingmvp.network.RetrofitHelper
import com.example.retrofitdemousingmvp.vehicleResponse.VehicleResponse
import com.example.retrofitdemousingmvp.vehicleResponse.VehicleResponseList

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.ArrayList

object VehicleRepository  {


    fun callVehicle(apiResponse: ApiResponse<VehicleResponseList>) {
        RetrofitHelper.getApiService().getVehicleData().enqueue(object : Callback<VehicleResponseList?> {
            override fun onResponse(call: Call<VehicleResponseList?>, response: Response<VehicleResponseList?>) {
                apiResponse.onSuccess(response.body()!!)



                Log.i("vehicle","response ${response.body()!!.data}")
            }

            override fun onFailure(call: Call<VehicleResponseList?>, t: Throwable) {
                apiResponse.onFailure(t.message)
            }
        })
    }
    /*fun callVehicle() = RetrofitHelper.getApiService().getVehicleData().enqueue(object : Callback<VehicleList?> {
        private val gsonConverter = GsonConverterFactory.create(GsonBuilder().setLenient().create())

        override fun onResponse(call: Call<VehicleList?>, response: Response<VehicleList?>) {
            val vehiclesResponseBody = response.body()
            vehicles.addAll(vehiclesResponseBody!!.data)
        }

        override fun onFailure(call: Call<VehicleList?>, t: Throwable) {
        }
    })*/
}