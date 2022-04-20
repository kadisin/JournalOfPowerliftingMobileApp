package com.example.journalofpowerlifting_.Presenter

import com.example.journalofpowerlifting_.InterfacesMVP.ContractMVP

class TrainerTrainingPresenter(_view: ContractMVP.TrainerTrainingView) {

    private var view: ContractMVP.TrainerTrainingView = _view

    fun UpdateSpinners()
    {
        view.UpdateSpinners(arrayListOf("Tomasz Łogisz","Adam Nowak","Dominik Nowakowski"))
    }


}