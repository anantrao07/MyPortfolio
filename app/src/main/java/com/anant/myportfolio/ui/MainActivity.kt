package com.anant.myportfolio.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.anant.myportfolio.R
import com.anant.myportfolio.ui.contracts.Backable
import com.anant.myportfolio.ui.fragments.ProfileFragment

class MainActivity : AppCompatActivity(), Backable {

    private lateinit var profileFragment: ProfileFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onResume() {
        super.onResume()
        profileFragment = ProfileFragment.newInstance()
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.container, profileFragment)
            .addToBackStack(null)
            .commit()
    }
}
