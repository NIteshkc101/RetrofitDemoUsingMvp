package com.example.retrofitget

import com.example.retrofitdemousingmvp.loginResponse.ApiResponse
import com.example.retrofitdemousingmvp.vehicle.VehicleInteractor
import com.example.retrofitdemousingmvp.vehicleResponse.VehicleResponseList
import com.hannesdorfmann.mosby3.mvp.MvpBasePresenter

class VehiclePresenter: MvpBasePresenter<VehicleView>() {

    private var vehicleInteractor: VehicleInteractor? = null

    override fun attachView(view: VehicleView) {
        super.attachView(view)
        vehicleInteractor = VehicleInteractor()
    }

    override fun detachView() {
        super.detachView()
        vehicleInteractor = null
    }

    fun callVehicleApi(){
        ifViewAttached { view ->
            vehicleInteractor?.callVehicle(object : ApiResponse<VehicleResponseList> {
                override fun onSuccess(response: VehicleResponseList) {

                    view.showVehicles(response)
                }



                override fun onFailure(message: String?) {
                    TODO("Not yet implemented")
                }
            })
        }
    }

}
