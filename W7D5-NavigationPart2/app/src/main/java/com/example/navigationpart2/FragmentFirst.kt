package com.example.navigationpart2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.example.navigationpart2.databinding.FragmentFirstBinding

class FragmentFirst : Fragment() {

    private lateinit var binding: FragmentFirstBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFirstBinding.inflate(inflater, container, false)

        binding.loginButton.setOnClickListener {

            val userPassword = "12345"

            if (binding.passwordEdittext.text.toString() == userPassword) {

                val userName = binding.userNameEdittext.text.toString()
                val userEmail = binding.emailEdittext.text.toString()

                val userInfoModel = UserInfo(userName, userEmail)

                val actionGoToSecondFragment =
                    FragmentFirstDirections.actionFragmentFirstToFragmentSecond(userInfoModel)
                Navigation.findNavController(it).navigate(actionGoToSecondFragment)

            } else {
                Toast.makeText(context, "Şifre yanlış!!!!", Toast.LENGTH_LONG).show()
            }


        }
        return binding.root
    }


}