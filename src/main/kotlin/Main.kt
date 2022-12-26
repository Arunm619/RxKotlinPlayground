import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

fun main(args: Array<String>) {
    Observable.range(1,10)
        .subscribeOn(Schedulers.computation())
        .subscribe {
                item -> println("Received $item")
        }
    runBlocking { delay(1) }
}