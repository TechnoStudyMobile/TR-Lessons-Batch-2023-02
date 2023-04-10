class PhysicsSystem {


    fun add(first:Int, second: Int):Int{
        return first*second
    }

    companion object WorldConstants{

       val gravity = 9.8
        val unit = "metric"

        fun computeForce(mass: Double, accel: Double): Double{
            return mass * accel
        }
    }
}