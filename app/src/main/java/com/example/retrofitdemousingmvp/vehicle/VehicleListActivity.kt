package com.example.retrofitdemousingmvp.vehicle

import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofitdemousingmvp.R
import com.example.retrofitdemousingmvp.adapter.VehiclesListAdapter
import com.example.retrofitdemousingmvp.vehicleResponse.VehicleResponse
import com.example.retrofitdemousingmvp.vehicleResponse.VehicleResponseList
import com.example.retrofitget.VehiclePresenter
import com.example.retrofitget.VehicleView
import com.hannesdorfmann.mosby3.mvp.MvpActivity
import java.util.ArrayList

class VehicleListActivity : MvpActivity<VehicleView, VehiclePresenter>(), VehicleView {

    lateinit var recyclerView: RecyclerView
    lateinit var adapter: VehiclesListAdapter
    var vehicles: MutableList<VehicleResponse> = ArrayList()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_vehicle_list)



        init()
    }

    private fun init() {
        recyclerView = findViewById(R.id.recycleViewVehicle)
        recyclerView.adapter = VehiclesListAdapter(vehicles)
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        getDataFromServer()
    }

    private fun getDataFromServer() {
        presenter.callVehicleApi()
    }

    override fun createPresenter() = VehiclePresenter()


    override fun showVehicles(vehicleList: VehicleResponseList) {
        recyclerView.adapter =VehiclesListAdapter(vehicleList.data)
        recyclerView.adapter?.notifyDataSetChanged()
    }


}