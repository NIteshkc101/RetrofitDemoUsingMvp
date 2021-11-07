package com.example.retrofitdemousingmvp.login

import com.example.retrofitdemousingmvp.loginResponse.ApiResponse
import com.example.retrofitdemousingmvp.loginResponse.LoginResponseData
import com.example.retrofitdemousingmvp.model.LoginRequest

class LoginInteractor {

    fun callLogin(loginRequest: LoginRequest, apiResponse: ApiResponse<LoginResponseData?>)=LoginRepository.callLogin(loginRequest
        ,apiResponse)
}