package com.example.journalofpowerlifting_.InterfacesMVP

interface ContractMVP {

    interface View {

        fun updateText(text: String) : Unit
        fun showError(text: String) : Unit
        fun showProgress(enable: Boolean) : Unit
        fun sendInformation(information: String) : Unit

    }

    interface TrainerTrainingView{
        fun UpdateSpinners(competitors: List<String>) : Unit

    }

    interface TrainerEditParametersView{
        fun UpdateTrainingDays(days: List<String>): Unit
        fun UpdateTrainingExercises(exercises: List<String>): Unit
        fun UpdateTrainingPlanSets(planSets: List<String>): Unit
    }

}