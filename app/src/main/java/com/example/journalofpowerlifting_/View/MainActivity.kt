package com.example.journalofpowerlifting_.View

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.journalofpowerlifting_.R
import com.example.journalofpowerlifting_.View.Fragments.AccountFragment
import com.example.journalofpowerlifting_.View.Fragments.TrainerTrainingFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private var accountFragment = AccountFragment()
    private var trainerTrainingFragment = TrainerTrainingFragment()

    private var bottomNavigation: BottomNavigationView? = null





    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_layout)

        InitializeView()

    }
    private fun InitializeView(){
        bottomNavigation = findViewById(R.id.BottomNavigation)
        bottomNavigation!!.setOnNavigationItemSelectedListener {
            when(it.itemId)
            {
                R.id.AccountMenu -> replaceFragment(accountFragment)
                R.id.TrainingMenu -> replaceFragment(trainerTrainingFragment)
            }
            true
        }
    }


    private fun replaceFragment(fragment: Fragment) {
        if (fragment != null) {
            val transaction = supportFragmentManager.beginTransaction()
            val bundle = Bundle()

            //bundle.putString("userToken", userToken)
            //fragment.arguments = bundle
            transaction.replace(R.id.FragmentContainter, fragment)
            transaction.commit()
        }
    }
}