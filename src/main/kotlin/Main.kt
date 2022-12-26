import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.disposables.Disposable
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import java.util.concurrent.TimeUnit

fun main() {
    val observable1 = Observable.range(1, 20)
    observable1.skip(5)//(1)
        .subscribe(object : Observer<Int> {
            override fun onError(e: Throwable) {
                println("Error $e")
            }

            override fun onComplete() {
                println("Complete")
            }

            override fun onNext(t: Int) {
                println("Received $t")
            }

            override fun onSubscribe(d: Disposable) {
                println("starting skip(count)")
            }
        })
    val observable2 = Observable.interval(100, TimeUnit.MILLISECONDS)
    observable2.skip(400, TimeUnit.MILLISECONDS)//(2)
        .subscribe(object : Observer<Long> {
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
        })
    runBlocking {
        delay(1000)
    }
}

/**
 * The skip operator has two important overloads: skip(count:Long) and
 * skip(time:Long, unit:TimeUnit); the first overload works on count, discarding the
 * first n number of emissions, while the second overload works on time, discarding all the
 * emissions that came in the specified time duration.
 * */