package com.example.journalofpowerlifting_.Presenter

import com.example.journalofpowerlifting_.InterfacesMVP.ContractMVP

class RegisterPresenter(_view: ContractMVP.View) {




    fun Register(login: String,password: String,name: String,surname: String,email: String,status: Int)
    {
        // connect to db, create new account return answer to _view

    }


}