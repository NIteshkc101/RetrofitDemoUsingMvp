package com.example.retrofitdemousingmvp.login

import com.hannesdorfmann.mosby3.mvp.MvpView

interface LoginView : MvpView {
    fun showProgressBar()
    fun hideProgressBar()
    fun showErrorMessage(message:String?)

    fun showToast(message: String)

    fun showValidationMessage(messageId:Int)
}