class Circle (val radius: Double) {

    val PI = 3.141592653589793


    constructor(name: String): this(1.0){
        println("in name constructor")
    }

    constructor(diameter:Int) : this(diameter / 2.0){
        println("in diameter constructor")
    }

    init {
        println("Area: ${Math.PI * radius*radius}")
    }
}