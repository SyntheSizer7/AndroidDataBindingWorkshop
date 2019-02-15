package com.synthesizer7.androiddatabinding.workshop

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.synthesizer7.androiddatabinding.workshop.profile.ProfileFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        supportFragmentManager.beginTransaction()
                .replace(android.R.id.content, ProfileFragment.newInstance(), ProfileFragment.TAG)
                .commit()
    }

}