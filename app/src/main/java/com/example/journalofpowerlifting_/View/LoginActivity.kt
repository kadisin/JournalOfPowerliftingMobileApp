package com.example.journalofpowerlifting_.View

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.journalofpowerlifting_.InterfacesMVP.ContractMVP
import com.example.journalofpowerlifting_.Presenter.LoginPresenter
import com.example.journalofpowerlifting_.R
import com.example.journalofpowerlifting_.RegisterActivity

class LoginActivity : AppCompatActivity(), ContractMVP.View {

    private var LoginEditText: EditText? = null
    private var PasswordEditText: EditText? = null
    private var presenter: LoginPresenter? = null

    private var LoginButton: Button? = null
    private var RegisterButton: Button? = null
    private var ResetPasswordButton: Button? = null




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login_layout)

        presenter = LoginPresenter(this)
        InitializeView()
    }

    private fun InitializeView(){
        LoginEditText = findViewById(R.id.LoginInput)
        PasswordEditText = findViewById(R.id.PasswordInput)

        LoginButton = findViewById(R.id.LoginButton)
        RegisterButton = findViewById(R.id.GoToRegisterButton)
        ResetPasswordButton = findViewById(R.id.GoToResetPasswordActivity)

        LoginButton!!.setOnClickListener(clickListener)
        RegisterButton!!.setOnClickListener(clickListener)
        ResetPasswordButton!!.setOnClickListener(clickListener)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }


    val clickListener = View.OnClickListener { view ->
        when(view.getId())
        {
            R.id.LoginButton -> SignIn()
            R.id.GoToRegisterButton -> sendInformation(Constants.REGISTER_ACTIVITY)
            R.id.GoToResetPasswordActivity -> sendInformation(Constants.RESET_PASSWORD_ACTIVITY)
        }
    }

    private fun SignIn()
    {
        if(ValidateInput())
        {
            var loginText = LoginEditText!!.text.toString()
            var passwordText = PasswordEditText!!.text.toString()

            updateText("Pomyślnie zalogowano!")
            //todelete
            sendInformation(Constants.MAIN_PAGE_ACTIVITY)
        }
    }

    private fun ValidateInput() : Boolean
    {
        var loginText = LoginEditText!!.text.toString()
        var passwordText = PasswordEditText!!.text.toString()

        if(loginText == "" || passwordText == "")
        {
            showError("Pole login i/lub hasło nie może być puste")
            return false
        }
        return true
    }



    override fun updateText(text: String) {
        Toast.makeText(this,text,Toast.LENGTH_LONG).show()
    }

    override fun showError(text: String) {
        Toast.makeText(this,text,Toast.LENGTH_LONG).show()
    }

    override fun showProgress(enable: Boolean) {
        TODO("Not yet implemented")
    }

    override fun sendInformation(information: String) {
        if(information == Constants.MAIN_PAGE_ACTIVITY)
        {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
        if(information == Constants.REGISTER_ACTIVITY)
        {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }
        if(information == Constants.RESET_PASSWORD_ACTIVITY)
        {
            val intent = Intent(this, RememberPasswordActivity::class.java)
            startActivity(intent)
        }
    }
}