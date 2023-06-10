package com.betulnecanli.weatherapp.ui.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.navArgs
import com.betulnecanli.weatherapp.databinding.FragmentDetailBinding

class DetailFragment : Fragment() {

    private lateinit var binding: FragmentDetailBinding
    private val args: DetailFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDetailBinding.inflate(inflater)

        Toast.makeText(requireContext(), "${args.time} -- ${args.maxTemp}", Toast.LENGTH_SHORT).show()
        initUI()

        return binding.root
    }

    private fun initUI() {
        with(binding) {
            tvTime.text = args.time
            tvMaxTemp.text = args.maxTemp.toString()
            tvMinTemp.text = args.minTemp.toString()
        }
    }
}