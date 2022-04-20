package com.example.journalofpowerlifting_.Presenter

import com.example.journalofpowerlifting_.InterfacesMVP.ContractMVP

class TrainerEditParametersPresenter(_view: ContractMVP.TrainerEditParametersView) {

    private var view: ContractMVP.TrainerEditParametersView = _view

    var days = arrayListOf("Poniedziałek","Wtorek","Czwartek")
    var exercises = arrayListOf("Wyciskanie sztangi leżąc","Przysiad","Podciąganie")
    var planSets = arrayListOf("10 - 100kg","4 - 50kg","3 - 50kg")

    fun AddTrainingDay(newDay: String)
    {
        days.add(newDay)
        UpdateTrainingDays()
    }

    fun AddTrainingExercise(newExercise: String)
    {
        exercises.add(newExercise)
        UpdateTrainingExercises()
    }

    fun AddTrainingPlanSet(newSeries: String, newReps: String, newWeight: String)
    {
        var planSet = newSeries + " - " + newReps + " - " + newWeight
        planSets.add(planSet)
        UpdateTrainingPlanSets()
    }

    fun DeleteTrainingDay(day: String)
    {
        days.remove(day)
        UpdateTrainingDays()
    }

    fun DeleteTrainingExercise(exercise: String)
    {
        exercises.remove(exercise)
        UpdateTrainingExercises()
    }

    fun DeleteTrainingPlanSet(planSet: String)
    {
        planSets.remove(planSet)
        UpdateTrainingPlanSets()
    }

    fun UpdateTrainingDays()
    {
        view.UpdateTrainingDays(days)
    }

    fun UpdateTrainingExercises()
    {
        view.UpdateTrainingExercises(exercises)
    }

    fun UpdateTrainingPlanSets()
    {
        view.UpdateTrainingPlanSets(planSets)
    }



}