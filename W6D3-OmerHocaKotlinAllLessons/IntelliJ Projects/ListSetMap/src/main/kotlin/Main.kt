fun main() {



    AppConstants.currentVersion
    AppConstants.BASE_URL + "listeler"
    //-------------------------------------List---------------------------------------------
    //List oluşturduk
    /*val numbers = listOf(1,2,3,4,5,6)

    //Listenin uzunluğunu almak
    println("Numbers'ın uzunluğu: ${numbers.size}")

    //Listenin 3. elemanına erişmek
    println("Numbars'ın 3. elemanı: ${numbers[2]}")

    //Bir elemanın indexini bulma
    println("5 in indexi: ${numbers.indexOf(5)}")

    //Bir elemanın var olup olmadığını kontrol etmek
    println("9 un indexi: ${numbers.indexOf(9)}")

    val person = Person("Ömer", 30)

    val peopleList = listOf(Person("Ahmet", 35), person, person)

    val peopleListTwo = listOf(Person("Ahmet",35),Person("Ömer",30), person)

    val peopleListThree = listOf(Person("Mehmet",35),Person("Ömer",30), person)

    println("Listelerin eşitlik durumu: ${peopleList == peopleListThree}")
*/


    //-------------------------------------MutableList---------------------------------------------

    val names = mutableListOf("Ömer", "Ahmet", "Mehmet", "Mustafa")

    //Ekleme
    names.add("Halil")

    //Silme
    names.removeAt(1)

    //Güncellme
    names[2] = "Oğuz"

    //Karıştırma
    names.shuffle()

    // println(names)


    //-------------------------------------Set---------------------------------------------

    /*val namesSet = setOf("Ömer", "Ahmet","Mehmet", "Mustafa","Ömer","Ömer","Ömer","Ömer","Ömer")
    println("NameSet elemanları${namesSet}")
    println("Nameset uzunluğu: ${namesSet.size}")

    if (namesSet.contains("Ahmet")){
        println("Ahmet setin içinde var")
    }else{
        println("Ahmet setin içinde yok")
    }*/

    //-------------------------------------MutableSet---------------------------------------------

    /* val namesMutableSet = mutableSetOf("Ömer","Ahmet", "Mustafa")

     namesMutableSet.remove("Ömer")
     namesMutableSet.add("Mehmet")

     //println(namesMutableSet.remove("asfasfa"))
     println(namesMutableSet)

     println("En son eleman: ${namesMutableSet.last()}")

     println("İlk eleman: ${namesMutableSet.first()}")
 */

    //-------------------------------------Map---------------------------------------------

    /*val namesMap = mapOf("Ömer" to 30, "Mustafa" to 40, "Oğuz" to 35)

    val namesMapTwo = mapOf("Oğuz" to 35, "Mustafa" to 40, "Ömer" to 30, "Ahmet" to 24)

    println("Bütün keyler: ${namesMap.keys}")

    println("Bütün value: ${namesMap.values}")


    if ("Ömer" in namesMap){
        println("Ömer var")
    }else{
        println("Ömer yok")
    }

    if (namesMap == namesMapTwo){
        println("Eşitler")
    }else{
        println("Eşit değiller")
    }*/


    //-------------------------------------MutableMap---------------------------------------------

    /* val namesMutableMap = mutableMapOf("Oğuz" to 35, "Mustafa" to 40, "Ömer" to 30, "Ahmet" to 24)

     namesMutableMap.remove("Oğuz")

     namesMutableMap["Can"] = 24

     namesMutableMap["Mustafa"] = 55

     println(namesMutableMap)
 */


    //-------------------------------------Filter---------------------------------------------

    /* val ages = listOf(24,27,29,30,32,35,43)
     println(ages.filter { it > 30})


     val namesList = listOf<String>("Ahmet","Mehmet", "Ayşe", "Betül")
     println(namesList.filter { it[1] == 'e' })

     val numbersSet = listOf(10,20,30,40)
     println(numbersSet.map { it+5 })
     println( numbersSet.map { it * 10 } )

     val numberSetPlusFive = numbersSet.map { it +5 }

     println(numberSetPlusFive)

     numbersSet.forEach {
         it*10
     }*/

    val numberListTwo = listOf(listOf(1, 2, 3), listOf(4, 5), listOf(9, 11))
    val list1 = listOf(1, 2, 3)
    val list2 = listOf(4, 5, 6)

    val list3 = list1.plus(list2)

    println(list3)
    println(numberListTwo.flatten())

    getPersonInfo().age
    getPersonInfo().name

    val name = getPersonInfo2().first
    val age = getPersonInfo2().second

    println("İsim:"+getPersonInfoTriple().first)
    println("Yaş:"+getPersonInfoTriple().second)
    println("Boy:"+getPersonInfoTriple().third)
}

/*fun getPersonInfo3(): String, Int, Double{

    return "Ömer", 30
}*/



fun getPersonInfo(): Person {
    return Person("Ömer", 30, 1.81)
    Math.PI
}


//Pair kullanımı
fun getPersonInfo2(): Pair<String, Int> {
    return Pair("Ömer", 30)
}

//Triple kullanımı
fun getPersonInfoTriple(): Triple<String,Int,Double>{
    return Triple("Ömer", 30,1.81)
}

data class Person(val name: String, var age: Int, var height: Double)