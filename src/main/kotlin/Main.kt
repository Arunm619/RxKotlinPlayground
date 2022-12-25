import io.reactivex.BackpressureStrategy
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

fun main() {
    val source = Observable.range(1, 641)
    source.toFlowable(BackpressureStrategy.MISSING)//(1)
        .onBackpressureBuffer()//(2)
        .map { MyItem11(it) }
        .observeOn(Schedulers.io())
        .subscribe{
            println(it)
            runBlocking { delay(10) }
        }
    runBlocking { delay(600000) }
}
data class MyItem11 (val id:Int) {
    init {
        println("MyItem Created $id")
    }
}