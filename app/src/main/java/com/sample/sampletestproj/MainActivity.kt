package com.sample.sampletestproj

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.sample.sampletestproj.databinding.ActivityMainBinding
import com.sample.sampletestproj.ui.movie.MovieList
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        replacefragment()
    }

    private fun replacefragment() {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fl_container,MovieList())
            .commit()
    }

}