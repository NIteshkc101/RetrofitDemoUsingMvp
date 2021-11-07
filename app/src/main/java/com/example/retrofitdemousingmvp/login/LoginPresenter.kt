package com.example.retrofitdemousingmvp.login

import com.example.retrofitdemousingmvp.R
import com.example.retrofitdemousingmvp.loginResponse.ApiResponse
import com.example.retrofitdemousingmvp.loginResponse.LoginResponseData
import com.example.retrofitdemousingmvp.model.LoginRequest
import com.hannesdorfmann.mosby3.mvp.MvpBasePresenter

class LoginPresenter  : MvpBasePresenter<LoginView>(){

    private var loginInteractor: LoginInteractor? = null

    override fun attachView(view: LoginView) {
        super.attachView(view)
        loginInteractor = LoginInteractor()
    }

    override fun detachView() {
        super.detachView()
        loginInteractor = null
    }

    fun callLoginApi(loginRequest: LoginRequest) {
        ifViewAttached { view ->
            if (!validateFields(loginRequest, view)) {
                return@ifViewAttached
            }
            view.showProgressBar()
            loginInteractor?.callLogin(loginRequest, object : ApiResponse<LoginResponseData?> {
                override fun onSuccess(response: LoginResponseData?) {
                    view.hideProgressBar()
                    view.showToast("Successly logged In")

                }

                override fun onFailure(message: String?) {
                    view.hideProgressBar()
                    view.showErrorMessage(message)
                }

            })

        }

    }


    fun login(){

    }

    private fun validateFields(loginRequest: LoginRequest, view: LoginView): Boolean {
        if (loginRequest.email.isNullOrEmpty()) {
            view.showValidationMessage(R.string.text_user_name_empty)
            return false
        } else if (loginRequest.password.isNullOrEmpty()) {
            view.showValidationMessage(R.string.text_password_empty)
            return false
        }
        return true
    }

}