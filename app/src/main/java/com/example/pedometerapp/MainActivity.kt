package com.example.pedometerapp2

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import android.view.View
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.addCallback
import androidx.appcompat.widget.PopupMenu
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.example.pedometerapp2.counter.CounterActivity
import com.example.pedometerapp2.databinding.ActivityMainBinding
import com.qamar.curvedbottomnaviagtion.CurvedBottomNavigation

class MainActivity : AppCompatActivity() {
    private lateinit var navController: NavController
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        //lateinit var autoCompleteTextView: AutoCompleteTextView

        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
        navController = navHostFragment.navController
//        navController.addOnDestinationChangedListener { _,_,_ ->
//
//            }

        bottomnavigation()

        //on back press
//        onBackPressedDispatcher.addCallback(this) {
//            if (!navController.popBackStack()) {
//                onBackPressedDispatcher.onBackPressed()
//            }
//        }

        // apply changes on back press
//        navController.addOnDestinationChangedListener { _, destination,_  ->
//            updateBottomNavigation(destination.id)
//        }

        }

    private fun bottomnavigation() {
        val curvedbottomnavigation: CurvedBottomNavigation =
            findViewById(R.id.curvedbottomnavigation)
        curvedbottomnavigation.add(CurvedBottomNavigation.Model(1, " ", R.drawable.home_icon))
        curvedbottomnavigation.add(CurvedBottomNavigation.Model(2, " ", R.drawable.map_runner_icon))
        curvedbottomnavigation.add(CurvedBottomNavigation.Model(3, " ", R.drawable.plan_icon))
        curvedbottomnavigation.add(CurvedBottomNavigation.Model(4, " ", R.drawable.leaderboard_icon))

        curvedbottomnavigation.setOnClickMenuListener {
            when (it.id) {
                1 -> {
                    navController.navigate(R.id.counterFragment)
                }

                2 -> {
                    navController.navigate(R.id.mapRunnerFragment)
                }

                3 -> {
                    navController.navigate(R.id.planFragment)
                }

                4 -> {
                    navController.navigate(R.id.leaderBoardFragment)
                }
            }
        }


    }

    private fun updateBottomNavigation(destinationId: Int) {
        val bottomNavigation = findViewById<CurvedBottomNavigation>(R.id.curvedbottomnavigation)
        when (destinationId) {
            R.id.counterFragment -> bottomNavigation.show(1)
            R.id.mapRunnerFragment -> bottomNavigation.show(2)
            R.id.planFragment -> bottomNavigation.show(3)
            R.id.leaderboard -> bottomNavigation.show(4)
        }

    }
}






