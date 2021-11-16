package com.example.retrofitdemousingmvp.vehicle

import com.example.retrofitdemousingmvp.loginResponse.ApiResponse
import com.example.retrofitdemousingmvp.vehicleResponse.VehicleResponseList
import com.example.retrofitget.VehicleRepository

class VehicleInteractor {
    fun callVehicle(apiResponse: ApiResponse<VehicleResponseList>) = VehicleRepository.callVehicle(apiResponse)

}