package com.tinyfalcon.w16d1_designpatterns

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // gang of four gof design patterns

        // new Object(); =>      5434@a   => add 10 =>  totalMoney = 10.00
        // new Object(); =>      23we@a   => add 20 =>  totalMoney = 20.00

        // new Object(); =>      2322@a   => add 10 =>  totalMoney = 10.00
        // getSingletonObject => 2322@a   => add 20 =>  totalMoney = 30.00

        val myAccount = MyAccount.getInstance()
        myAccount.getBalance() // 0.0f
        myAccount.addMoney(10f)
        myAccount.getBalance() // 10.0f


        val myAccount2 = MyAccount.getInstance()
        myAccount2.addMoney(20f)

    }

    class MyAccount {
        companion object {
            var myAccount: MyAccount? = null

            fun getInstance(): MyAccount {
                if (myAccount == null) {
                    myAccount = MyAccount()
                }
                return myAccount!!
            }
        }

        private var totalMoney = 0.0f

        fun getBalance()  = totalMoney

        fun addMoney(amount: Float) {
            totalMoney += amount
        }
    }

    /*
        mainThread =>
        backgroundThread =>
     */
}