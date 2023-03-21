import java.lang.IllegalArgumentException
import javax.crypto.Mac

fun main() {
    // new
    // new MainActivity()
    // MainActivity()
    val deneme1 = MainActivity()
    val deneme2 = SecondActivity()
    val deneme3 = BaseActivity()
    deneme3.showProgress()

    val deneme4 = BaseAbstractActivity()
    deneme4.provideProgressBarColor()

    val deneme5 = FifthActivity()
    deneme5.provideProgressBarColor() // red

    val deneme6 = object : BaseAbstractActivity() {
        override val counter: Int
            get() = 10

        override fun provideProgressBarColor(): String {
            return "deneme6 çalışır"
        }
    }
    deneme6.provideProgressBarColor()

    val deneme7 = object : Contract2 {
        override fun contractTime(): String {
            return "next_year"
        }
    }
    deneme7.contractTime()
}

abstract class BaseAbstractActivity {

    abstract val counter: Int

    open fun showProgress() {
        val color = provideProgressBarColor()
        // display colored progress
    }

    abstract fun provideProgressBarColor(): String
}

// MainActivity => BaseActivity => BiggestBaseActivity
open class BiggestBaseActivity

// base, parent, super
open class BaseActivity: BiggestBaseActivity() {

    open fun showProgress() {
        // show  progress
        //sdfsdf
        //sdfsf
        // adskf
    }
}

//class Dog extends Animal
//class Dog implements Animal
class MainActivity: BaseActivity() {

    //@Override -> Annotation
    override fun showProgress() {
        // show blue progress
    }

    fun showDialog() {}

    fun showRecyclerView() {}
}

class SecondActivity: BaseActivity() {

    fun something() {}
}

class ThirdActivity: BaseActivity() {

}

class ForthActivity: BaseAbstractActivity() {
    override val counter: Int
        get() = 40

    override fun provideProgressBarColor(): String {
        return "blue"
    }

    override fun showProgress() {
        super.showProgress()
    }
}

class FifthActivity: BaseAbstractActivity() {
    override val counter: Int
        get() = 24

    override fun provideProgressBarColor(): String {
        return "red"
    }
}


interface BaseInterface {
    fun anotherMethod(deger: Int): Double
}

// INTERFACES, fonksiyonun/metodun imzası
interface ContractInterface: BaseInterface {
    fun monthlyWage(): Int
    fun contractTime(): String
}

abstract class ContractAbstract {
    abstract fun monthlyWage(): Int
    abstract fun contractTime(): String
}

interface Contract1 {
    fun monthlyWage(): Int
}

interface Contract2 {
    fun contractTime(): String
}

abstract class Contract3 {
    abstract fun monthlyWage(): Int
}

abstract class Contract4 {
    abstract fun contractTime(): String
}

class Utility: Contract3(), Contract1 {
    override fun monthlyWage(): Int {
        return 30
    }
}

class Utility2: Contract1, Contract2 {
    override fun monthlyWage(): Int {
        return 30
    }

    override fun contractTime(): String {
        return ""
    }
}
