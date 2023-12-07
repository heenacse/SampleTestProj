package com.sample.sampletestproj.ui.splashscreenui

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.sample.sampletestproj.MainActivity
import com.sample.sampletestproj.R
import com.sample.sampletestproj.databinding.ActivityMainBinding
import com.sample.sampletestproj.databinding.ActivitySplashScreenBinding
import com.sample.sampletestproj.ui.guestlogin.GuestLogin
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SplashScreen : AppCompatActivity() {

    private lateinit var binding: ActivitySplashScreenBinding
    private val viewModel by viewModels<SplashViewModel>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySplashScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)
        observer()
    }

    private fun observer() {
        viewModel.splscreen.observe(this, Observer{
            when(it){
                is SplashState.MainActivity -> {
                    goToMainActivity()
                }
            }
        })
    }

    private fun goToMainActivity() {
        finish()
        startActivity(Intent(this, MainActivity::class.java))
    }
}