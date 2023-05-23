package com.example.marsapp.view

import android.content.Context
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.marsapp.R
import com.example.marsapp.api.MarsApiService
import com.example.marsapp.data.MarsResponseItem

import com.example.marsapp.repo.MarsPropertyRepostory
import com.example.marsapp.view.adapters.MarsPropertyAdapter


class MainActivity : AppCompatActivity() {

    private lateinit var viewModel:MainViewModel
    private lateinit var recyclerView: RecyclerView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val marsApiService = MarsApiService.create()
        val marsPropertyRepostory = MarsPropertyRepostory(this,marsApiService)
        val viewModelFactory = MarsViewModelFactory(marsPropertyRepository = marsPropertyRepostory)
        viewModel = ViewModelProvider(this, factory = viewModelFactory)[MainViewModel::class.java]

        recyclerView = findViewById(R.id.recycler_view)

        val buttonBuy = findViewById<Button>(R.id.buttonBuy)
        val buttonRent = findViewById<Button>(R.id.buttonRent)
        val buttonPrice = findViewById<Button>(R.id.buttonPrice)
        val editTextPrice = findViewById<EditText>(R.id.editTextPrice)

        /*
        viewModel.properties.observe(this, Observer { marsResponse ->
            setupRecyclerView(marsResponse)
        })*/

        viewModel.filterProperties(50000,150000).observe(this, Observer { marsResponse ->
            setupRecyclerView(marsResponse)
        })
    }

    private fun setupRecyclerView(marsProperties: List<MarsResponseItem>) {
        val adapter = MarsPropertyAdapter(marsProperties)
        recyclerView.adapter = adapter
    }
}