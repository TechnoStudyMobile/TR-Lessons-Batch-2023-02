sealed class OyunKarakteri {
    class Savasci(val hasar: Int, val zirh: Int) : OyunKarakteri()
    class Büyücü(val mana: Int, val büyü: String) : OyunKarakteri()
    class Hırsız(val çalmaYeteneği: Int, val taklitYeteneği: Int) : OyunKarakteri()
}