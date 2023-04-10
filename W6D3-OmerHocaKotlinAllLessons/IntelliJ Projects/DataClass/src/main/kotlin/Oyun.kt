class Oyun {
    fun karakterOlustur(karakter: OyunKarakteri) {
        when (karakter) {
            is OyunKarakteri.Savasci -> {
                println("Savaşçı karakter oluşturuldu. Hasar: ${karakter.hasar}, Zırh: ${karakter.zirh}")
            }
            is OyunKarakteri.Büyücü -> {
                println("Büyücü karakter oluşturuldu. Mana: ${karakter.mana}, Büyü: ${karakter.büyü}")
            }
            is OyunKarakteri.Hırsız -> {
                println("Hırsız karakter oluşturuldu. Çalma Yeteneği: ${karakter.çalmaYeteneği}, Taklit Yeteneği: ${karakter.taklitYeteneği}")
            }
        }
    }
}