package com.example.retrofitdemousingmvp.login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.retrofitdemousingmvp.ProgressDialogHelper
import com.example.retrofitdemousingmvp.R
import com.example.retrofitdemousingmvp.model.LoginRequest
import com.hannesdorfmann.mosby3.mvp.MvpActivity
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : MvpActivity<LoginView,LoginPresenter>(),LoginView {

    private var dialogHelper: ProgressDialogHelper? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        
        btnLogin.setOnClickListener { loginUser() }
    }

    private fun loginUser() {
        presenter.callLoginApi(LoginRequest(edtUserName.text.toString(),edtPassword.text.toString()))


    }

    override fun createPresenter(): LoginPresenter  = LoginPresenter()
    override fun showProgressBar() {
        dialogHelper?.show(getString(R.string.text_loading))
    }

    override fun hideProgressBar() {
        dialogHelper?.dismiss()
    }


    override fun showErrorMessage(message: String?) {
        Toast.makeText(this@LoginActivity,message, Toast.LENGTH_SHORT).show()
    }

    override fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }


    override fun showValidationMessage(messageId: Int) {
        Toast.makeText(this@LoginActivity,getString(messageId), Toast.LENGTH_SHORT).show()
    }
}