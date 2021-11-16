package com.example.retrofitdemousingmvp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.example.retrofitdemousingmvp.login.LoginActivity
import com.example.retrofitdemousingmvp.vehicle.VehicleListActivity
import com.example.retrofitdemousingmvp.vehicleResponse.VehicleResponse

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var vehiclesList: ArrayList<VehicleResponse>

    private lateinit var vehicleButton: Button
    private lateinit var loginButton: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        vehicleButton = findViewById(R.id.vehicleButton)
        loginButton = findViewById(R.id.loginButton)

        vehicleButton.setOnClickListener(this)
        loginButton.setOnClickListener(this)
    }

    override fun onClick(view: View?) {
        if (view == vehicleButton) {

            val intent = Intent(this@MainActivity, VehicleListActivity::class.java)
            startActivity(intent)


        }
        if (view == loginButton) {

            val intent = Intent(this@MainActivity, LoginActivity::class.java)
            startActivity(intent)


        }

    }
}