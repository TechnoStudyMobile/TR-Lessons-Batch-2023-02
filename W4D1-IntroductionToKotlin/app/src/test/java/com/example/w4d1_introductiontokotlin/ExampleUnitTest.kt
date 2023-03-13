package com.example.w4d1_introductiontokotlin

import org.junit.Test

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {

    @Test
    fun addition_isCorrect() {
        println(4 + 4)
        println(4 - 4)
        println(4 / 4)
        println(4 * 4)

        // mod
        // 4 % 2 -> 0   6 % 2 -> 0   8 % 2 -> 0
        // 5 % 2 -> 1   7 % 2 -> 1   9 % 2 -> 1
        // 1 % 2 -> 1
        // 5 % 7 -> 5

        // primitive hali -> int  class/object hali-> Integer
        // Int, Float, Double, String

        // TODO: -> 2.times

        // 8 bit -> 1 byte

        // int myNumber = 10
        var myNumber: Int = 10
        myNumber = 20

        // val -> final
        val finalNumber = 50
        finalNumber = 3

        var myName: String = null
        var myFavNumber: Int = null

        var myName1: String = "blabla"
        var myFavNumber1: Int = 10

        var mySecondName: String? = null
        var mySecondFavNumber: Int? = null

        // force null
        myFavNumber1 = mySecondFavNumber!!

        // mySecondName = "Sahin"
        myName1 = mySecondName ?: "unknown"

        if(mySecondName == null) {
            myName1 = "unknown"
        } else {
            myName1 = mySecondName
        }

        myName1.drop(6)
        mySecondName?.drop(3)

        if(mySecondName != null) {
            mySecondName.drop(3)
        }

        // private String name;
        // private String name = null;
        // private String name = "hello";

        // private String name = "berkay"
        // name.split() -> "ber"
        // "berkay".split() -> "ber"

        // private String name = null
        // name.split() ->
        // null.split() -> NPE : Null Pointer Exception
    }
}