package com.example.w7d1_fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment

class ListFragment: Fragment() {

    // FRAGMENT LIFECYCLE IS DIFFERENT THAN ACTIVITY'S
    // BOILERPLATE
    // kotlin idiom, java idiom

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        /*
        val myLayoutInflator: LayoutInflater = LayoutInflater.from(context)
        val myView: View = myLayoutInflator.inflate(R.layout.fragment_list, container, false)
        return myView
         */
        return inflater.inflate(R.layout.fragment_list, container, false)
    }

    override fun onStart() {
        super.onStart()
        // Toast.makeText(this, "message", Toast.LENGTH_SHORT).show()
        // Toast.makeText(activity, "message", Toast.LENGTH_SHORT).show()
        Toast.makeText(context, "message", Toast.LENGTH_SHORT).show()
    }
}