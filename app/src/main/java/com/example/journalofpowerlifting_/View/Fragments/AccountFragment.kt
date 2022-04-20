package com.example.journalofpowerlifting_.View.Fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import com.example.journalofpowerlifting_.R
import com.example.journalofpowerlifting_.RegisterActivity
import com.example.journalofpowerlifting_.View.LoginActivity


class AccountFragment : Fragment() {

    private var _view: View? = null
    private var ChangePasswordButton: Button? = null
    private var ChangeEmailButton: Button? = null

    private var EditText1: EditText? = null
    private var EditText2: EditText? = null
    private var SendChangeButton: Button? = null

    private var LinearLayout: LinearLayout? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _view = inflater.inflate(R.layout.account_fragment_layout, container, false)

        InitializeView(_view)
        //return inflater.inflate(R.layout.account_fragment_layout, container, false)
        return _view;
    }

    private fun InitializeView(_view: View?)
    {
        ChangePasswordButton = _view!!.findViewById(R.id.ChangePasswordButton)
        ChangeEmailButton = _view!!.findViewById(R.id.ChangeEmailButton)

        ChangePasswordButton!!.setOnClickListener(clickListener)
        ChangeEmailButton!!.setOnClickListener(clickListener)

        EditText1 = _view!!.findViewById(R.id.EditText1)
        EditText2 = _view!!.findViewById(R.id.EditText2)
        SendChangeButton = _view!!.findViewById(R.id.SendChangeButton)

        SendChangeButton!!.setOnClickListener(clickListener)

        LinearLayout = _view!!.findViewById(com.google.android.material.R.id.container)
    }


    val clickListener = View.OnClickListener { view ->
        when(view.getId()) {
            //R.id.ChangePasswordButton -> ChangePassword()
            //R.id.ChangeEmailButton -> ChangeEmail()
            //R.id.SendChangeButton -> ShowCard()
        }
    }
/*
    private fun ShowCard()
    {
        AddCard()
    }


    private fun AddCard(){
        var view: View = layoutInflater.inflate(R.layout.account_settings_cardview, null)

        LinearLayout!!.addView(view)


    }

    private fun ChangePassword(){
        EditText1!!.hint = "Podaj nowe hasło"
        EditText2!!.hint = "Powtórz hasło"



    }
    private fun ChangeEmail(){
        EditText1!!.hint = "Podaj nowy e-mail"
        EditText2!!.hint = "Powtórz email"

    }



*/
    companion object {
        fun newInstance() = AccountFragment()

    }
}