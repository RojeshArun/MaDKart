package com.letslearntogether.madkart

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.letslearntogether.madkart.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    //Binding
    private lateinit var binding: ActivityMainBinding

    //List - Recycler view
    private val adapter = ProductCardListAdapter()



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //Binding
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Recycle view
        binding.viewProductList.layoutManager= LinearLayoutManager(this,
            LinearLayoutManager.VERTICAL, false)
        binding.viewProductList.adapter = adapter





    }
}