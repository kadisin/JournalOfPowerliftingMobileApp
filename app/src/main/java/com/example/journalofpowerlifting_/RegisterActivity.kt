package com.example.journalofpowerlifting_

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import com.example.journalofpowerlifting_.InterfacesMVP.ContractMVP
import com.example.journalofpowerlifting_.Presenter.RegisterPresenter
import com.example.journalofpowerlifting_.View.Constants
import com.example.journalofpowerlifting_.View.LoginActivity

class RegisterActivity : AppCompatActivity(), ContractMVP.View {

    private var LoginEditText: EditText? = null
    private var PasswordEditText: EditText? = null
    private var EmailEditText: EditText? = null
    private var NameEditText: EditText? = null
    private var SurNameEditText: EditText? = null

    private var RegisterButton: Button? = null
    private var BackToLoginActivityButton: Button? = null

    private var StatusFirstRadiobutton: RadioButton? = null
    private var StatusSecondRadiobutton: RadioButton? = null

    private var presenter: RegisterPresenter? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.register_layout)

        presenter = RegisterPresenter(this)

        InitializeView()
    }

    private fun InitializeView(){
        LoginEditText = findViewById(R.id.LoginInput)
        PasswordEditText = findViewById(R.id.PasswordInput)
        EmailEditText = findViewById(R.id.EmailInput)
        NameEditText = findViewById(R.id.NameInput)
        SurNameEditText = findViewById(R.id.SurnameInput)

        StatusFirstRadiobutton = findViewById(R.id.FirstStatusRadiobutton)
        StatusSecondRadiobutton = findViewById(R.id.SecondStatusRadiobutton)

        RegisterButton = findViewById(R.id.RegisterNewAccountButton)
        BackToLoginActivityButton = findViewById(R.id.BackToLoginButton)

        RegisterButton!!.setOnClickListener(clickListener)
        BackToLoginActivityButton!!.setOnClickListener(clickListener)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    val clickListener = View.OnClickListener { view ->
        when(view.getId())
        {
            R.id.BackToLoginButton -> sendInformation(Constants.LOGIN_ACTIVITY)
        }
    }

    private fun Register()
    {
        if(ValidateInput())
        {
            var loginText = LoginEditText!!.text.toString()
            var passwordText = PasswordEditText!!.text.toString()
            var emailText = EmailEditText!!.text.toString()
            var nameText = NameEditText!!.text.toString()
            var surnameText = SurNameEditText!!.text.toString()

            //var status = StatusFirstCheckbox.
             //   StatusFirstCheckbox!!.isChecked() == true

        }
    }

    private fun ValidateInput() : Boolean
    {
        var loginText = LoginEditText!!.text.toString()
        var passwordText = PasswordEditText!!.text.toString()
        var emailText = EmailEditText!!.text.toString()
        var nameText = NameEditText!!.text.toString()
        var surnameText = SurNameEditText!!.text.toString()

        if(loginText == "" || passwordText == "" || emailText == "" || nameText == "" || surnameText == "")
        {
            showError("Żadne pole nie może być puste")
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
        if(information == Constants.LOGIN_ACTIVITY)
        {
            val intent = Intent(this,LoginActivity::class.java)
            startActivity(intent)
        }
    }
}