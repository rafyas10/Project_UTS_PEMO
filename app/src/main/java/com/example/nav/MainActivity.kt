package com.example.nav

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import android.widget.Toast
import android.os.Handler

class MainActivity : AppCompatActivity() {
    private var doubleBackToExitPressedOnce = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // bottom nav

        val bottomnav = findViewById<BottomNavigationView>(R.id.bottomnavview)
        bottomnav.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.bot_menu_home -> {
                    loadFragment(f_home())
                    true
                }

                R.id.bot_menu_calc -> {
                    loadFragment(fcalc())
                    true
                }

                R.id.bot_menu_profile -> {
                    loadFragment(fprofile())
                    true
                }

                else -> { false }
            }
        }

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.f_container, f_home())
                .commit()
        }
    }

    // change fragment

    private fun loadFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.f_container, fragment)
        transaction.commit()
    }

    override fun onBackPressed() {
        if (doubleBackToExitPressedOnce) {
            super.onBackPressed()
            // Quit the app
            finishAffinity()
        } else {
            this.doubleBackToExitPressedOnce = true
            Toast.makeText(this, "Press back again to exit", Toast.LENGTH_SHORT).show()

            Handler().postDelayed({
                doubleBackToExitPressedOnce = false
            }, 2000) // Reset the flag after a 2-second delay
        }
    }
}
