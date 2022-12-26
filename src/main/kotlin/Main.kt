import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.disposables.Disposable
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import java.util.concurrent.TimeUnit

fun main() {
    val observable1 = Observable.interval(100, TimeUnit.MILLISECONDS)
    val observable2 =
        Observable.timer(500,TimeUnit.MILLISECONDS)//(1)
    observable1
        .skipUntil(observable2)//(2)
        .subscribe(
            object: Observer<Long> {
                override fun onError(e: Throwable) {
                    println("Error $e")
                }
                override fun onComplete() {
                    println("Complete")
                }
                override fun onNext(t: Long) {
                    println("Received $t")
                }
                override fun onSubscribe(d: Disposable) {
                    println("starting skip(time)")
                }
            }
        )
    runBlocking { delay(1500) }
}

/**
 *  we used that Observable instance (observable2) as the parameter to the skipUntil
 * operator, which will make it discard all the emissions of observable1 until observable2
 * emits.
 *
 * */