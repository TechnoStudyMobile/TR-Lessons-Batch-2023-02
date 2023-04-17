package com.example.mvvmguesstwordpart2.welcome

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.mvvmguesstwordpart2.databinding.WelcomeFragmentBinding
import com.example.mvvmguesstwordpart2.share.ShareViewModel

class WelcomeFragment : Fragment() {

    private lateinit var binding: WelcomeFragmentBinding

    private val viewModel: ShareViewModel  by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = WelcomeFragmentBinding.inflate(inflater, container, false)


        binding.playGameButton.setOnClickListener {
            findNavController().navigate(WelcomeFragmentDirections.actionWelcomeFragmentToGameFragment())
        }
        viewModel.userName = "Muhammed Emin Uysal"

        return binding.root
    }
}