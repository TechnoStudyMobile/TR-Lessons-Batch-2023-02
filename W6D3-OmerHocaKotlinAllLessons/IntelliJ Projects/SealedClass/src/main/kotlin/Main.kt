import java.util.regex.Pattern
import javax.naming.Context

fun main() {



    /*val oyun = Oyun()
    val savasci = Oyunkarakteri.Savasci(20,35)

    val buyucu = Oyunkarakteri.Buyucu(37,48)

    val hirsiz = Oyunkarakteri.Hirsiz(47,36)
    val hirsiz2 = Oyunkarakteri.Hirsiz(21,30)

    oyun.karakterOlustur(hirsiz)
    oyun.karakterOlustur(hirsiz2)
*/


//    println(string1.addPercent())

   /* val int1 = 100
    println(int1.ucleCarp())



    val test = Test()
    test.ucleCarp2(int1)

    int1.ucleCarp()*/

/*
   val email = "test@gmail.com"
    println(email.isEmailValid())
    */

   /* val x = "50"
    x.addPercent()
    println(x.addPercent())

    val integerDeger = 60
    integerDeger.ucleCarp()
*/

   /* val list = mutableListOf(1, 2, 3,4,5,6,7,8)
    list.swap(2, 5)
    println(list)*/


   /* var name: String? = "Ömer"

    name?.let{ isim ->
        println("Name: $isim")
    }?: println("Name is null")

*/


   /* var x: Int? = null
    x = 10

    val y = x?.let { x1->
        x1 + 20
    } ?: 0

    println("x: $x, y: $y")*/


    var name: Int? = 10
    name = null

    val result = name?.run {
        println("Name: $this")
    }?: 0

    println("Result: $result")


}



fun String.isEmailValid(): Boolean {
    val expression = "^[\\w.-]+@([\\w\\-]+\\.)+[A-Z]{2,8}$"
    val pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE)
    val matcher = pattern.matcher(this)
    return matcher.matches()
}






/*fun String.addPercent(): String{
    return "%$this"
}

fun Int.ucleCarp(): Int{
    return this * 3
}*/

