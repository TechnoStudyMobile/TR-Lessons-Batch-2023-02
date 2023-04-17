package com.example.foodmenuapp.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.foodmenuapp.databinding.FragmentHomeBinding
import com.example.foodmenuapp.model.MenuModel

class HomeFragment : Fragment(), MenuAdapter.MenuItemClickListener {

    private lateinit var binding: FragmentHomeBinding
    private val viewModel: HomeViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentHomeBinding.inflate(inflater)

        viewModel.getMenuList()
        initObservers()

        // Inflate the layout for this fragment
        return binding.root
    }

    private fun initObservers() {
        viewModel.menuList.observe(viewLifecycleOwner) { list ->
            initRecycler(list)
        }
    }

    private fun initRecycler(menuList: List<MenuModel>) {
        val menuAdapter = MenuAdapter(menuList, this)
        binding.recyclerViewMenus.apply {
            layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
            adapter = menuAdapter
        }
    }

    override fun onItemClicked(menuModel: MenuModel.MenuItems) {
        Toast.makeText(context, "${menuModel.menuName} sepete eklendi!", Toast.LENGTH_LONG).show()
    }

    override fun onItemClickedNavigate(menuModel: MenuModel.MenuItems) {
        findNavController().navigate(
            HomeFragmentDirections.actionHomeFragmentToDetailFragment(
                menuModel
            )
        )
    }
}