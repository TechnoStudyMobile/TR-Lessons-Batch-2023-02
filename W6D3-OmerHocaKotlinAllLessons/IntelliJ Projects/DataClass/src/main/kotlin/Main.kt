fun main() {

    /*val firstPlayer = Player("Ömer", 100)

    // toString methodu otomatik olarak oluşturulduğu için Player(name=Ömer, score=100) sonucunu aldık.
    println(firstPlayer)

    // firstPlayer' direkt olarak kopyaladık
    val copyPlayer1 = firstPlayer.copy()
    println(copyPlayer1)

    // firstPlayer'ın name'ini değiştirerek kopyaladık
    val copyPlayer2 = firstPlayer.copy(name = "Ahmet")
    println(copyPlayer2)

    // firstPlayer'ın score'unu değiştirerek kopyaladık
    val copyPlayer3 = firstPlayer.copy(score = 35)
    println(copyPlayer3)

    // parametreleri sıralamasını göre yazdırdık
    println(copyPlayer3.component1())
    println(copyPlayer3.component2())

    println(Calculator.add(10,20))


    println(PhysicsSystem.WorldConstants.gravity)

    println(PhysicsSystem.WorldConstants.computeForce(10.0,10.0))

    val testObject = PhysicsSystem()
    println(testObject.add(10,7))*/

    //getPlayerSkill(PlayerType.WARRIOR)

   // getPlayerSkillTest("Priest")
    //getPlayerSkillTest("Racer")
   // getPlayerSkillTest("Student")


    var name: String? = "John"
    name = null

    name?.let {
        println("Name: $it")
    } ?: println("Name is null")





    var x: Int? = null

    val y = x?.let {
        it + 10
    } ?: 0

    println("x: $x, y: $y")




    val name: String? = "John"

    val result = name?.run {
        println("Name: $this")
        this.length
    } ?: 0

    println("Result: $result")



    var x = 5

    val y = x.run {
        this + 10
    }

    println("x: $x, y: $y")

}

fun getPlayerSkillTest(player: String){
    when(player){
        "Priest" ->{println("priest can heal the party members")}
        "Student" -> { println("Student diye bir player yok")
        }
    }
}

fun getPlayerSkill(player: PlayerType){
    when(player){
        PlayerType.PRIEST-> { println("priest can heal the party members")     }
        PlayerType.ASSAIAN->{  println("assassian can increas the total power when use critical damage skill")    }
        PlayerType.WARRIOR->{   println("Warrior gördün mü kaç!!!")   }
    }
}

object Calculator{
    fun add(n1: Int, n2:Int):Int{
        return n1 + n2
    }
}

