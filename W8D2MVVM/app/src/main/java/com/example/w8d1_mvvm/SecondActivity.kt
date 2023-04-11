package com.example.w8d1_mvvm

import android.os.Bundle
import android.widget.TextView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SecondActivity : AppCompatActivity() {
    private val viewModel: SecondViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (viewModel.matchResultLiveData.value == null) {
            viewModel.getMatchResults("GS")
        }

        viewModel.matchResultLiveData.observe(this) {
            showMatchResult(it)
        }
    }
    private fun showMatchResult(matchResult: String) {
        val myText = findViewById<TextView>(R.id.my_text)
        myText.text = matchResult
    }
}

class SecondViewModel: ViewModel() {
    val matchResultLiveData = MutableLiveData<String>()

    fun getMatchResults(team: String) {
        val allMatchResults = getAllMatchResults()
        if (team == "GS") {
            val gsMatchResult = allMatchResults[0]
            matchResultLiveData.value = gsMatchResult
        } else if (team == "FB") {
            val fbMatchResult = allMatchResults[1]
            matchResultLiveData.value = fbMatchResult
        }
    }

    private fun getAllMatchResults(): List<String> {
        val matchResults = arrayListOf<String>()
        matchResults.add("GS 1 - 2 GSB")
        matchResults.add("FB 2 - 2 FBB")
        matchResults.add("BJK 1 - 3 BJKB")
        return matchResults
    }
}