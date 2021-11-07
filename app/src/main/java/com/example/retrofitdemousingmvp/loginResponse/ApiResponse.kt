package com.example.retrofitdemousingmvp.loginResponse

interface ApiResponse<T> {
    fun onSuccess(response: T)
    fun onFailure(message:String?)
}