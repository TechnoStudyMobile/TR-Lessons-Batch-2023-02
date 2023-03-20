import java.lang.IllegalArgumentException
import javax.crypto.Mac

fun main() {
    val myClass = ClassRoom()
    myClass.tableCount
    //myClass.setTableCount(10)
    myClass.tableCount = 10

    val mainActivity = MainActivity()
    mainActivity.showProgress()

    val secondActivity = SecondActivity()
    secondActivity.showProgress()

    val thirdActivity = ThirdActivity()
    thirdActivity.showProgress()

    val activities = listOf<BaseActivity>(
        mainActivity, secondActivity, thirdActivity
    )

    for (activity in activities) {
        // instance of
        /*
            if (activity instanceof MainActivity) {
                ((MainActivity) activity ).showRecyclerView()
            }
         */

        // Kotlin'de yazım şekli 1 : Hataya açık patlayabilir.
        (activity as MainActivity).showRecyclerView()

        // Kotlin'de yazım şekli 2 : Hata almaz.
        (activity as? MainActivity)?.showRecyclerView()

        // Kotlin'de yazım şekli 3 : Hata almaz.
        if (activity is SecondActivity) {
            activity.something()
        }

        // casting exception
        //activity.showProgress()
    }

}

class ClassRoom {
     private val a: String = ""

     var tableCount: Int = 0
        get() = 0
        set(value) {
            if (value >= 50) {
                field = 1
            } else {
                field = 0
            }
        }

    /*
    fun setTableCount2(sayi: Int) {
        if (sayi > 12) {
            tableCount = sayi;
        } else {
            throw IllegalArgumentException()
        }
    }

     */
}

abstract class BaseAbstractActivity {

    open fun showProgress() {
        val color = provideProgressBarColor()
        // display colored progress
    }

    abstract fun provideProgressBarColor(): String
}

// base, parent
open class BaseActivity {

    open fun showProgress() {
        // show red progress
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
    override fun provideProgressBarColor(): String {
        return "blue"
    }
}

class FifthActivity: BaseAbstractActivity() {
    override fun provideProgressBarColor(): String {
        return "red"
    }
}