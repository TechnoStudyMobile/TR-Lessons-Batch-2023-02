class Person(var firstName: String, var lastName: String, var age: Int, var job: String) {
    var personInfo: String = ""
        get() {
            return "Kişinin adı $firstName $lastName , ve kişinin yaşı $age, mesleği $job ...."
        }
        set(value) {
            val components = value.split("-")
            firstName = components[0]
            lastName = components[1]
            job = components[2]
            field = value
        }

   private var newAge: Int = 0
        get() {
            return age
        }
        set(value) {
            age = value
            field = value
            println("$age. yaşınız kutlu olsun!!!")
        }

   fun updateNewAge(newAgeUpdateValue: Int){
        newAge = newAgeUpdateValue
        println("Yaş güncellendi $newAge")
    }

    private fun updateAge(newAge2:Int){
        age = newAge2
    }
}