fun main() {
    val degisken = "str"

    // val degisken2 = fun

    //val degisken1 = sayHello()
    //val degisken1 = sayHello

    val degisken2 = ::sayHello
    val degisken3 = ::greeting

    degisken2.invoke()
    degisken3.invoke("volkan")

    degisken2()                     // sayHello()
    degisken3("volkan")      // greeting("volkan")

    val name = "volkan"
    greeting(name)

    val deneme = ::greeting
    //takesParam(deneme)
    takesParam(::greeting)
    takesParam(::goodBye)
    takesParam2(::greetingParam2)

    val denemeWithType: (String) -> Unit = ::greeting
    val denemeWithType2: (String) -> Unit = { x -> println("Hello $x") }

    denemeWithType2("kaan")
}

fun sayHello() {
    println("Hello")
}

fun greeting(name: String): Unit {
    println("Hello $name")
}

/*
                                { name ->
        println("Hello $name")
    }
 */


fun goodBye(name: String): Unit {
    println("Good bye $name")
}

fun greetingParam2(name: String, param: Int): Unit {
    println("Hello $name")
}

fun getMessage() : String {
    return "myMessage"
}

/*
fun takesParams(f: KFunction1<String, Unit>) {
}
*/

fun takesParam(param: (String) -> Unit) {
    param("campus")
}

fun takesParam2(param: (String, Int) -> Unit) {
    //g.invoke("campus")
}


