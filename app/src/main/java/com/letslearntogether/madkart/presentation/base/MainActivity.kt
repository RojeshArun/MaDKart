package com.letslearntogether.madkart.presentation.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.letslearntogether.madkart.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

//Step 10 Hilt
                    // handles the definition of entry points
                    // and access to the entry points for these classes
@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

}