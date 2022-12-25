import io.reactivex.BackpressureStrategy
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

fun main() {
    val source = Observable.range(1, 1000)
    source.toFlowable(BackpressureStrategy.ERROR)
        .map { MyItem8(it) }
        .observeOn(Schedulers.io())
        .subscribe{
            println(it)
            runBlocking { delay(600) }
        }
    runBlocking { delay(700000) }
}
data class MyItem8 (val id:Int) {
    init {
        println("MyItem Created $id")
    }
}