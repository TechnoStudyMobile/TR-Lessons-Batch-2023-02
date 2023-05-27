package com.betulnecanli.weatherapp.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.betulnecanli.weatherapp.databinding.FragmentHomeBinding
import com.betulnecanli.weatherapp.model.WeatherResponse
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class HomeFragment : Fragment() {

    private lateinit var binding : FragmentHomeBinding
    private val viewModel: HomeViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater)
        viewModel.getDataFromService()
        initObserve()
        return binding.root
    }

    private fun initObserve(){
        viewModel.weatherData.observe(viewLifecycleOwner){
            initRecyclerView(it)
        }
    }

    private fun initRecyclerView(weatherResponse: WeatherResponse?){
        val adapter = weatherResponse?.let { HomeAdapter(it) { position ->
            val time = weatherResponse.daily.time[position]
            val maxTemp = weatherResponse.daily.apparent_temperature_max[position]
            val minTemp = weatherResponse.daily.apparent_temperature_min[position]
            Toast.makeText(requireContext(), position.toString(), Toast.LENGTH_SHORT).show()
            findNavController().navigate(HomeFragmentDirections.actionHomeFragmentToDetailFragment(
                time,
                maxTemp.toFloat(),
                minTemp.toFloat()
            ))
        }}
        binding.weatherRV.adapter= adapter
        binding.weatherRV.apply {
            layoutManager = LinearLayoutManager(requireContext())
            setHasFixedSize(true)
        }
    }
}