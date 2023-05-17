package com.betulnecanli.weatherapp.ui.home


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.app.NotificationManagerCompat
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.betulnecanli.weatherapp.data.local.WeatherDB
import com.betulnecanli.weatherapp.databinding.FragmentHomeBinding
import com.betulnecanli.weatherapp.model.WeatherResponse
import com.betulnecanli.weatherapp.network.WeatherService
import com.betulnecanli.weatherapp.repository.WeatherRepository
import com.betulnecanli.weatherapp.util.MyViewModelFactory
import com.betulnecanli.weatherapp.util.sendNotification

class HomeFragment : Fragment() {

    private lateinit var binding : FragmentHomeBinding
    private lateinit var viewModel : HomeViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater)

        val repository = WeatherRepository(WeatherService.create(), WeatherDB.getInstance(requireContext()))
        val factory = MyViewModelFactory(repository)
        viewModel = ViewModelProvider(requireActivity(), factory)[HomeViewModel::class.java]

        viewModel.getDataFromService()
        initObserve()
        return binding.root
    }

    private fun initObserve(){
        viewModel.weatherData.observe(viewLifecycleOwner){
            initRecyclerView(it)
            NotificationManagerCompat.from(requireContext()).sendNotification("Current Weather", it?.current_weather?.temperature.toString(), requireContext())
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