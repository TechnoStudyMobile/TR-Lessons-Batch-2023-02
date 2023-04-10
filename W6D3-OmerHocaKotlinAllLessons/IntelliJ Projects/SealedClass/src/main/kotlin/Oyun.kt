class Oyun {
    fun karakterOlustur(karakter: Oyunkarakteri) {
        when (karakter) {
            is Oyunkarakteri.Savasci -> {
                println("Savaşcı karakter oluşturuldu:Hasar: ${karakter.hasar}, Zırh:${karakter.zirh} ")
            }
            is Oyunkarakteri.Buyucu -> {
                println("Buyucu karakter oluşturuldu:Buyu: ${karakter.buyu}, Mana:${karakter.mana} ")
            }
            is Oyunkarakteri.Hirsiz -> {
                println("Hırsız karakter oluşturuldu:Çalma yeteneği: ${karakter.calmaYetenegi}, Taklit yeteneği:${karakter.taklitYetenegi} ")
            }
        }
    }


}