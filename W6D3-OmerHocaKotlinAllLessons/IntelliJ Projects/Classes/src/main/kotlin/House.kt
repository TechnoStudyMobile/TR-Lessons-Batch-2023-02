class House(area: Int, room: Int) {

    var color: String = "Blue"
    var numberOfWindows : Int = 3
    var isForSale: Boolean = false


    fun updateColor(color: String){
        this.color = color
    }

    fun updateSaleStatus(isSale:Boolean){
        this.isForSale = isSale
    }

    init {
        println("Evin metrekaresi $area , oda sayısı $room...")
    }

}