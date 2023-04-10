class Araba:ArabaHareketEttirici  {

    override fun ileriGit(hiz: Int) {
        println("Araba ileri gidiyor ve hızı: $hiz km/s")
    }

    override fun geriGit(hiz: Int) {
        println("Araba geri gidiyor ve hızı: $hiz km/s")
    }
}