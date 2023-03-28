fun main() {
    val result = calculate(10, 5, "/")
    println(result)

    val result2 = calculate(10, 5, ::divide)
    println(result2)

    sayYourMessage(::getHelloMessage)

    sayYourMessage {
        "deneme"
    }

    sayYourMessage {
        getHelloMessage()
    }

    sayYourMessage2 { param: String ->
        getMyMessage(param)
    }

    sayYourMessageWithAction("My message", { println("and my action") })

    sayYourMessageWithAction("My message") {
        println(" and my action")
    }
}

fun sayYourMessage(getMessageFunc: () -> String) {
    println(getMessageFunc())
}

fun sayYourMessage2(getMessageFunc: (String) -> String) {
    println(getMessageFunc("this is my message"))
}

fun sayYourMessage3(getMessageFunc: ((Int, Int) -> Float) -> String) {

}

fun add(firstNum: Int, secondNum: Int) = firstNum + secondNum

fun subtract(firstNum: Int, secondNum: Int) = firstNum - secondNum

fun times(firstNum: Int, secondNum: Int) = firstNum * secondNum

fun divide(firstNum: Int, secondNum: Int) = firstNum / secondNum

fun calculate(firstNum: Int, secondNum: Int, operation: String): Int {
    return when(operation) {
        "+" -> add(firstNum, secondNum)
        "-" -> subtract(firstNum, secondNum)
        "*" -> times(firstNum, secondNum)
        "/" -> divide(firstNum, secondNum)
        else -> throw IllegalArgumentException()
    }
}

fun calculate(firstNum: Int, secondNum: Int, operation: (Int, Int) -> Int) = operation(firstNum, secondNum)

fun getMyMessage(message: String): String = "Your message is $message"

fun getHelloMessage(): String = "Hello"

fun getGoodByeMessage() = "Good Bye"

fun sayYourMessage(message: String) { println(message) }



fun sayYourMessageWithAction(message: String, action: () -> Unit) {
    println(message)
    action()
}


fun sam() {
    val myFunction = ::getMyMessage
    val myFunction1 = { param: String -> println(param) }

    // SAM
    val myInterface: Runnable = InterfaceDeneme()
    val myInterface1: Runnable = object : Runnable {
        override fun run() {
            // some code inside run
        }
    }
    val myInterface2: Runnable = Runnable {
        //some code inside run
    }

    val interfaceWithTwoFun: TwoFunctionInterface = object : TwoFunctionInterface {
        override fun firstFunc() {
        }
        override fun secondFunc() {
        }
    }
}

// is a, has a
class InterfaceDeneme: Runnable {
    override fun run() {
    }
}

interface OnClickListener {
    fun onClick()
}

interface TwoFunctionInterface {
    fun firstFunc()
    fun secondFunc()
}


