sealed class Oyunkarakteri{
    class Savasci(val hasar:Int,val zirh:Int) : Oyunkarakteri()
    class Buyucu(val mana:Int, val buyu:Int): Oyunkarakteri()
    class Hirsiz(val calmaYetenegi:Int, val taklitYetenegi:Int):Oyunkarakteri()
}
