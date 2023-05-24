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
import dagger.hilt.android.AndroidEntryPoint
import retrofit2.Retrofit
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    //private lateinit var viewModel:MainViewModel
    private lateinit var recyclerView: RecyclerView

    private val viewModel by viewModels<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

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