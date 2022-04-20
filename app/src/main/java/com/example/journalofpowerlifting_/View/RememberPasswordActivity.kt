package com.example.journalofpowerlifting_.View

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.journalofpowerlifting_.InterfacesMVP.ContractMVP
import com.example.journalofpowerlifting_.R

class RememberPasswordActivity : AppCompatActivity(),ContractMVP.View {

    private var RememberPasswordEmailEditText: EditText? = null
    private var RememberPasswordButton: Button? = null
    private var BackToLoginActivityButton: Button? = null



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.remember_password_layout)

        InitializeView()

    }

    private fun InitializeView(){
        RememberPasswordEmailEditText = findViewById(R.id.EmailToRememberPasswordInput)
        RememberPasswordButton = findViewById(R.id.RememberPasswordButton)
        BackToLoginActivityButton = findViewById(R.id.BackToLoginButton)

        RememberPasswordButton!!.setOnClickListener(clickListener)
        BackToLoginActivityButton!!.setOnClickListener(clickListener)

    }


    val clickListener = View.OnClickListener { view ->
        when(view.getId())
        {
            R.id.RememberPasswordButton -> RememberPassword()
            R.id.BackToLoginButton -> sendInformation(Constants.LOGIN_ACTIVITY)
        }
    }

    private fun RememberPassword(){
        if(ValidateEmail()) {
            var emailText = RememberPasswordEmailEditText!!.text.toString()


        }
    }

    private fun ValidateEmail() : Boolean
    {
        var emailText = RememberPasswordEmailEditText!!.text.toString()
        if(emailText == "")
            showError("Pole e-mail nie może być puste")
            return false;
        return true;
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
        if(information.equals(Constants.LOGIN_ACTIVITY))
        {
            val intent = Intent(this,LoginActivity::class.java)
            startActivity(intent)
        }
    }

}