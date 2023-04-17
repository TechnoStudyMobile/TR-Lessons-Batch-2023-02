package com.example.mvvmguesstwordpart2.score

import android.os.Binder
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.example.mvvmguesstwordpart2.databinding.ScoreFragmentBinding
import com.example.mvvmguesstwordpart2.share.ShareViewModel

class ScoreFragment : Fragment() {

    private lateinit var binding: ScoreFragmentBinding

    private val args: ScoreFragmentArgs by navArgs()

    private val viewModel: ShareViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = ScoreFragmentBinding.inflate(inflater, container, false)
        binding.scoreText.text = args.scoreFromGame.toString()

        binding.youScoredText.text = viewModel.userName


        return binding.root
    }
}