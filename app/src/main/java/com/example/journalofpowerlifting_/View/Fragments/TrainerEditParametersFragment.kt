package com.example.journalofpowerlifting_.View.Fragments

import android.app.AlertDialog
import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import android.text.InputType
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.journalofpowerlifting_.InterfacesMVP.ContractMVP
import com.example.journalofpowerlifting_.Presenter.TrainerEditParametersPresenter
import com.example.journalofpowerlifting_.R
import com.example.journalofpowerlifting_.View.Constants


class TrainerEditParametersFragment : Fragment(),ContractMVP.TrainerEditParametersView {


    private var _view: View? = null

    private var TrainingDaysSpinner: Spinner? = null
    private var TrainingExercisesSpinner: Spinner? = null
    private var TrainingPlanSetSpinner: Spinner? = null

    private var AddTrainingDayButton : Button? = null
    private var DeleteTrainingDayButton: Button? = null

    private var AddTrainingExerciseButton: Button? = null
    private var DeleteTrainingExerciseButton: Button? = null

    private var AddTrainingPlanSetButton: Button? = null
    private var DeleteTrainingPlanSetButton: Button? = null

    private var presenter: TrainerEditParametersPresenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter = TrainerEditParametersPresenter(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _view =  inflater.inflate(R.layout.trainer_training_fragment, container, false)
        InitializeView(_view)
        return _view
    }

    private fun InitializeView(_view: View?)
    {
        TrainingDaysSpinner = _view!!.findViewById(R.id.TrainingDays)
        TrainingExercisesSpinner = _view!!.findViewById(R.id.TrainingExercises)
        TrainingPlanSetSpinner = _view!!.findViewById(R.id.TrainingPlanSets)

        AddTrainingDayButton = _view!!.findViewById(R.id.AddTrainingDayButton)
        DeleteTrainingDayButton = _view!!.findViewById(R.id.DeleteTrainingDayButton)

        AddTrainingExerciseButton = _view!!.findViewById(R.id.AddTrainingExerciseButton)
        DeleteTrainingExerciseButton = _view!!.findViewById(R.id.DeleteTrainingExerciseButton)

        AddTrainingPlanSetButton = _view!!.findViewById(R.id.AddTrainingPlanSetButton)
        DeleteTrainingPlanSetButton = _view!!.findViewById(R.id.DeleteTrainingPlanSetButton)


        AddTrainingDayButton!!.setOnClickListener(clickListener)
        DeleteTrainingDayButton!!.setOnClickListener(clickListener)

        AddTrainingExerciseButton!!.setOnClickListener(clickListener)
        DeleteTrainingExerciseButton!!.setOnClickListener(clickListener)

        AddTrainingPlanSetButton!!.setOnClickListener(clickListener)
        DeleteTrainingPlanSetButton!!.setOnClickListener(clickListener)

        presenter!!.UpdateTrainingDays()
        presenter!!.UpdateTrainingExercises()
        presenter!!.UpdateTrainingPlanSets()

    }


    val clickListener = View.OnClickListener { view ->
        when(view.getId())
        {
            R.id.AddTrainingDayButton -> AddTrainingDay()
            R.id.DeleteTrainingDayButton -> DeleteTrainingDay()

            R.id.AddTrainingExerciseButton -> AddTrainingExercise()
            R.id.DeleteTrainingExerciseButton -> DeleteTrainingExercise()

            R.id.AddTrainingPlanSetButton -> AddTrainingPlanSet()
            R.id.DeleteTrainingPlanSetButton -> DeleteTrainingPlanSet()

        }
    }


    private fun AddTrainingDay()
    {
        val builder = AlertDialog.Builder(context)
        builder.setTitle("Dzień treningowy")

        val input = EditText(context)
        input.setHint("Dodaj dzień")
        input.inputType = InputType.TYPE_CLASS_TEXT
        builder.setView(input)

        builder.setPositiveButton("OK", DialogInterface.OnClickListener{
            dialog, which ->
            var newDay = input.text.toString()
            if(newDay != "") {
                presenter!!.AddTrainingDay(newDay)
            }
            else
            {
                Toast.makeText(context,"Pole dzień nie może być puste",Toast.LENGTH_LONG).show()
            }
        })
        builder.setNegativeButton("Anuluj",DialogInterface.OnClickListener{
            dialog, which -> dialog.cancel()
        })
        builder.show()

    }

    private fun AddTrainingExercise()
    {
        val builder = AlertDialog.Builder(context)
        builder.setTitle("Cwiczenia")

        val input = EditText(context)
        input.setHint("Dodaj cwiczenie")
        input.inputType = InputType.TYPE_CLASS_TEXT
        builder.setView(input)

        builder.setPositiveButton("OK", DialogInterface.OnClickListener{
                dialog, which ->
            var newExercise = input.text.toString()
            if(newExercise != "")
            {
                presenter!!.AddTrainingExercise(newExercise)
            }
            else
            {
                Toast.makeText(context,"Pole cwiczenie nie może być puste",Toast.LENGTH_LONG).show()
            }
        })
        builder.setNegativeButton("Anuluj",DialogInterface.OnClickListener{
                dialog, which -> dialog.cancel()
        })
        builder.show()
    }
    private fun AddTrainingPlanSet()
    {
        val builder = AlertDialog.Builder(context)
        builder.setTitle("Serie")

        val layout: LinearLayout = LinearLayout(context)
        layout.orientation = LinearLayout.VERTICAL

       val inputSeries = EditText(context)
        inputSeries.setHint("Podaj serie")
        inputSeries.inputType = InputType.TYPE_CLASS_TEXT
        builder.setView(inputSeries)

        val inputReps = EditText(context)
        inputReps.setHint("Podaj powtorzenia")
        inputReps.inputType = InputType.TYPE_CLASS_TEXT
        builder.setView(inputReps)

        val inputWeight = EditText(context)
        inputWeight.setHint("Podaj ciezar")
        inputWeight.inputType = InputType.TYPE_CLASS_TEXT

        layout.addView(inputSeries)
        layout.addView(inputReps)
        layout.addView(inputWeight)
        builder.setView(layout)

        builder.setPositiveButton("OK", DialogInterface.OnClickListener{
                dialog, which ->
            var newSeries = inputSeries.text.toString()
            var newReps = inputReps.text.toString()
            var newWeight = inputWeight.text.toString()
            if(ValidatePlanSeries(newSeries,newReps,newWeight)) {
                presenter!!.AddTrainingPlanSet(newSeries, newReps, newWeight)
            }
            else
            {
                Toast.makeText(context,"Pole serii musi być wypełnione, wszystkie pola muszą być liczbami!",Toast.LENGTH_LONG).show()
            }
            })
        builder.setNegativeButton("Anuluj",DialogInterface.OnClickListener{
                dialog, which -> dialog.cancel()
        })
        builder.show()
    }

    private fun ValidatePlanSeries(series: String, reps: String, weight: String) : Boolean
    {
        if(series != "")
        {
            try {
                var seriesInt = series.toInt()
            }
            catch(ex: Exception)
            {
                return false
            }
            if(reps != ""){
                try {
                    var repsInt = reps.toInt()
                }
                catch(ex1: Exception)
                {
                    return false
                }
            }
            if(weight != "")
            {
                try {
                    var weightInt = weight.toInt()
                }
                catch(ex2: Exception)
                {
                    return false
                }
            }
        }
        else
        {
            return false
        }
        return true
    }


    private fun DeleteTrainingDay()
    {
        var selectedText = TrainingDaysSpinner!!.selectedItem.toString()
        presenter!!.DeleteTrainingDay(selectedText)
    }

    private fun DeleteTrainingExercise()
    {
        var selectedText = TrainingExercisesSpinner!!.selectedItem.toString()
        presenter!!.DeleteTrainingExercise(selectedText)
    }

    private fun DeleteTrainingPlanSet()
    {
        var selectedText = TrainingPlanSetSpinner!!.selectedItem.toString()
        presenter!!.DeleteTrainingPlanSet(selectedText)
    }


    companion object {
        fun newInstance() = TrainerEditParametersFragment()

    }

    override fun UpdateTrainingDays(days: List<String>) {
        //TrainingDaysSpinner = _view!!.findViewById(R.id.TrainingDays)
        val adapterTrainingDays: ArrayAdapter<String> = ArrayAdapter<String>(requireActivity(),
            R.layout.spinner_item_layout, days)
        TrainingDaysSpinner!!.adapter = adapterTrainingDays

    }

    override fun UpdateTrainingExercises(exercises: List<String>) {

        //TrainingExercisesSpinner = _view!!.findViewById(R.id.TrainingExercises)
        val adapterUpdateTrainingExercises: ArrayAdapter<String> = ArrayAdapter<String>(requireActivity(),
            R.layout.spinner_item_layout, exercises)
        TrainingExercisesSpinner!!.adapter = adapterUpdateTrainingExercises
    }

    override fun UpdateTrainingPlanSets(planSets: List<String>) {
        //TrainingPlanSetSpinner = _view!!.findViewById(R.id.TrainingPlanSets)
        val adapterUpdateTrainingPlanSets: ArrayAdapter<String> = ArrayAdapter<String>(requireActivity(),
            R.layout.spinner_item_layout, planSets)
        TrainingPlanSetSpinner!!.adapter = adapterUpdateTrainingPlanSets
    }

}