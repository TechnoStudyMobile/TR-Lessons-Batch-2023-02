package com.example.foodmenuapp.ui.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.example.foodmenuapp.databinding.FragmentDetailBinding

class DetailFragment : Fragment() {

    private lateinit var binding: FragmentDetailBinding
    private val args: DetailFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentDetailBinding.inflate(inflater)

        initView()

        // Inflate the layout for this fragment
        return binding.root
    }

    private fun initView() {
        val menuItem = args.menuItem

        with(binding) {
            tvMenuTitle.text = menuItem.menuName
            tvMenuDesc.text = menuItem.menuDesc
            tvMenuAmount.text = menuItem.amount
            ivMenuImg.setImageResource(menuItem.imageResource)
        }
    }
}
