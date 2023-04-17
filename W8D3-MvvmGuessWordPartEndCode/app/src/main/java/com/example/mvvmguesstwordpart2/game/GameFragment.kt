package com.example.mvvmguesstwordpart2.game

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.mvvmguesstwordpart2.databinding.GameFragmentBinding

class GameFragment : Fragment() {

    private lateinit var binding: GameFragmentBinding

    private val viewModel: GameViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = GameFragmentBinding.inflate(inflater, container, false)

        binding.skipButton.setOnClickListener {
            viewModel.onSkip()
        }

        binding.correctButton.setOnClickListener {
            viewModel.onGotIt()
        }

        binding.endGameButton.setOnClickListener {
            val score = binding.scoreText.text.toString().toInt()
            findNavController().navigate(GameFragmentDirections.actionGameFragmentToScoreFragment().setScoreFromGame(score))
        }

        viewModel.score.observe(viewLifecycleOwner) { score ->
            binding.scoreText.text = score.toString()
        }

        viewModel.word.observe(viewLifecycleOwner) { word ->
            binding.wordText.text = word
        }

        return binding.root
    }
}