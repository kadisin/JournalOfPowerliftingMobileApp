package com.example.journalofpowerlifting_.View

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.journalofpowerlifting_.R
import com.example.journalofpowerlifting_.View.Fragments.TrainerEditParametersFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class TrainerAddTrainingActivity : AppCompatActivity() {


    private var bottomNavigation: BottomNavigationView? = null

    private var trainerEditParametersFragment = TrainerEditParametersFragment()






    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.trainer_add_training_activity)
        InitializeView()

    }

    private fun InitializeView()
    {
        bottomNavigation = findViewById(R.id.TrainerTrainingBottomNavigation)

        bottomNavigation!!.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.ChangeParameters -> replaceFragment(trainerEditParametersFragment)
            }
            true
        }
    }
    private fun replaceFragment(fragment: Fragment){
        if(fragment != null){
            val transaction = supportFragmentManager.beginTransaction()
            val bundle = Bundle()

            transaction.replace(R.id.FragmentContainter, fragment)
            transaction.commit()
        }
    }

}