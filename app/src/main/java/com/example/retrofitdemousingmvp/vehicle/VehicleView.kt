package com.example.retrofitget


import com.example.retrofitdemousingmvp.vehicleResponse.VehicleResponseList
import com.hannesdorfmann.mosby3.mvp.MvpView

interface VehicleView:MvpView {
 fun showVehicles(vehicleList: VehicleResponseList)
}
