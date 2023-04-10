package com.example.navigationpart2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.example.navigationpart2.databinding.FragmentSecondBinding


class FragmentSecond : Fragment() {

    private lateinit var binding: FragmentSecondBinding

    val args: FragmentSecondArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSecondBinding.inflate(inflater, container, false)
        binding.textViewUserEmail.text = args.userInfoModel.userName
        return binding.root
    }
}