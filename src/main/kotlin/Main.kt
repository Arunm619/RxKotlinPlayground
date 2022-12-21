import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

fun main() {
    val observable = Observable.range(1, 200000)//1, 2, 3, 4, 5, 6, 7, 8, 9)//(1)
    observable.map { MyItem(it) }//(2)
        .observeOn(Schedulers.computation())//(3)
        .subscribe {//(4)
            println("Received $it")
            runBlocking { delay(1) }//(5)
        }
    runBlocking { delay(200000) }//(6)
}

data class MyItem(val id: Int) {
    init {
        println("MyItem Created $id")//(7)
    }
}