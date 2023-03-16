//script scripting

fun main() {

    var myCounter : Int? = null
    var nonNullCounter : Int

    // Int? -> 32 milyon + null
    // Int -> 32 milyon

    //nonNullCounter = myCounter!!
    nonNullCounter = myCounter ?: 100

    if (myCounter != null) {
        nonNullCounter = myCounter
    } else {
        nonNullCounter = 100
    }

    nonNullCounter.inc()
    myCounter?.inc() // Null Pointer Exception - NPE

    if (myCounter != null) {
        myCounter.inc()
    }

    // Boolean isGreaterThanThirty = false
    var isGreaterThanThirty = false

    if (nonNullCounter > 30) {
        isGreaterThanThirty = true
    } else {
        isGreaterThanThirty = false
    }

    isGreaterThanThirty = if (nonNullCounter > 30) {
         true
    } else {
        false
    }

    isGreaterThanThirty = nonNullCounter > 30

    for(int i = 0; i < 30; i++) {
        text[i]
    }

    for(String s : text) {
        s
    }

    List<String> myList = new ArrayList<String>();
    myList.add("a")
    myList.add("b")
    myList.add("c")

    val myKotlinArrayList = arrayListOf("a","b","c")
    val myKotlinList = listOf<String>()
    val myKotlinList2 = mutableListOf<String>()

    myKotlinArrayList.add(3, "sfdsdf")
    myKotlinList.add("")
    myKotlinList2.add("")

    myKotlinList.toMutableList()
    ArrayList(myKotlinList)

    // list, arrayList

    // new int[4]; x x x x
    // new int[5]; x x x x x
}

fun firstLesson() {

    // int -> primitive   10
    // Integer -> class/object  -> Integer.parseInt("10") -> 10

    // Int = 10  Int.range()

    Int deger = 10;
    Int newDeger = ++deger;
    print(deger)

    deger.toByte()
    deger.toString()
    deger.toLong()

    Int million = 1_000_000_000

    val dogs = 10
    val cats = 20

    val message = "x adet köpek, y adet kedi vardır!"

    dogs + " adet köpek, " + cats + " adet kedi vardır!"

    "${}"
    tw.setText("$dogs adet köpek, ${cats} adet kedi vardır!")

    dogs
    "$dogs"
    "${dogs}"

    // final - constant - immutable
    val random = 10
    random = 11 // yapılamaz

    // var -> degisken - mutable
    var random2 = 9
    random2 = 10

    private val myValue = 20
}