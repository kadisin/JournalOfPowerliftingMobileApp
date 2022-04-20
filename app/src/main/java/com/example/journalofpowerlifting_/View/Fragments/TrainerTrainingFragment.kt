package com.example.journalofpowerlifting_.View.Fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import com.example.journalofpowerlifting_.InterfacesMVP.ContractMVP
import com.example.journalofpowerlifting_.Presenter.TrainerTrainingPresenter
import com.example.journalofpowerlifting_.R
import com.example.journalofpowerlifting_.View.Constants
import com.example.journalofpowerlifting_.View.TrainerAddTrainingActivity


class TrainerTrainingFragment : Fragment(),ContractMVP.TrainerTrainingView {

    private var _view: View? = null

    private var ChooseCompetitorSpinner: Spinner? = null
    private var ChooseAmountOfDaysSpinner: Spinner? = null

    private var StartTrainerTrainingButton: Button? = null

    private var presenter: TrainerTrainingPresenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        presenter = TrainerTrainingPresenter(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _view = inflater.inflate(R.layout.trainer_training_layout, container, false)
        //return inflater.inflate(R.layout.trainer_training_layout, container, false)
        InitializeView(_view)

        return _view
    }

    private fun InitializeView(_view: View?){

        StartTrainerTrainingButton = _view!!.findViewById(R.id.StartTrainerTrainingButton)
        StartTrainerTrainingButton!!.setOnClickListener(clickListener)

        presenter!!.UpdateSpinners()

    }

    val clickListener = View.OnClickListener {
        when(it.getId())
        {
            R.id.StartTrainerTrainingButton ->StartTrainerTraining()
        }
    }

    private fun StartTrainerTraining()
    {
        // get data from spinners
        val intent = Intent(activity,TrainerAddTrainingActivity::class.java)
        startActivity(intent)
    }


    override fun UpdateSpinners(competitors: List<String>){
        ChooseCompetitorSpinner =_view!!.findViewById(R.id.ChooseCompetitor)
        ChooseAmountOfDaysSpinner = _view!!.findViewById(R.id.ChooseAmountOfDays)

        val listOfCompetitors = ArrayList<String>()
        for(competitors in competitors)
        {
            listOfCompetitors.add(competitors)
        }

        val listAmountOfDays = Constants.AmountOfDaysTraining

        val adapterCompetitors: ArrayAdapter<String> = ArrayAdapter<String>(requireActivity(),
            R.layout.spinner_item_layout, listOfCompetitors)
        val adapterDays : ArrayAdapter<String> = ArrayAdapter<String>(requireActivity(),
            R.layout.spinner_item_layout, listAmountOfDays)

        ChooseCompetitorSpinner!!.adapter = adapterCompetitors
        ChooseAmountOfDaysSpinner!!.adapter = adapterDays


    }


    companion object {
        fun newInstance() = TrainerTrainingFragment()
    }
}