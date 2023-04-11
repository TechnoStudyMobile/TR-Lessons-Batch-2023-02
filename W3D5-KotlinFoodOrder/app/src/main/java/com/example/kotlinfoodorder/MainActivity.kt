package com.example.kotlinfoodorder

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val editTextCustomerName = findViewById<EditText>(R.id.the_name_of_customer_text_view)
        val checkBoxWhippedCream = findViewById<CheckBox>(R.id.check_box_whipped_cream)
        val checkBoxChocolatte = findViewById<CheckBox>(R.id.check_box_chocolate)
        val amountsTextView = findViewById<TextView>(R.id.amounts_text_view)
        val decreaseButton = findViewById<Button>(R.id.btn_iki_azalt)
        val inreaseButton = findViewById<Button>(R.id.btn_iki_arttir)
        val orderTextView = findViewById<TextView>(R.id.order_summary_text_view)
        val textViewAmount = findViewById<TextView>(R.id.textViewAmountFood)
        val orderButton = findViewById<Button>(R.id.btn_order)


        var isSelectedWhippedCream = false
        checkBoxWhippedCream.setOnCheckedChangeListener { buttonView, isChecked ->
            isSelectedWhippedCream = isChecked
        }

        var isSelectedChocolatteCream = false
        checkBoxChocolatte.setOnCheckedChangeListener { buttonView, isChecked ->
            isSelectedChocolatteCream = isChecked
        }

        var foodCount = 0
        inreaseButton.setOnClickListener {
            foodCount++
            amountsTextView.text = foodCount.toString()
        }

        decreaseButton.setOnClickListener {
            if (foodCount > 0) {
                foodCount--
            }
            amountsTextView.text = foodCount.toString()
        }

        orderButton.setOnClickListener {

            val customerName = editTextCustomerName.text.toString()

             var  whippedCreamSelection = ""
            whippedCreamSelection = if (isSelectedWhippedCream) {
                "Whipped Cream isteniyor."
            } else {
                "Whipped Cream istenmiyor."
            }

            var chocolatteCreamSelection = ""
            chocolatteCreamSelection = if (isSelectedChocolatteCream) {
                "Chocolatte Cream isteniyor."
            } else {
                "Chocolatte Cream istenmiyor."
            }

            var foodCountStr = "Sipariş adeti: $foodCount"

            var amount = textViewAmount.text.toString().toInt() * foodCount

            if (isSelectedWhippedCream){
                amount += 2
            }

            if (isSelectedChocolatteCream){
                amount += 4
            }

            orderTextView.text =
                "$customerName \n $whippedCreamSelection \n $chocolatteCreamSelection \n $foodCountStr \n Toplam sepet tutarı: $amount TL"

        }


        // if ile yazım
        /*
         if (checkBoxWhippedCream.isChecked){
            isSelectedWhippedCream = true
         }else{
             isSelectedWhippedCream = false
         }
          */


    }
}