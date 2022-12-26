import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlin.time.ExperimentalTime
import kotlin.time.measureTime

@OptIn(ExperimentalTime::class)
fun main(args: Array<String>) {
    var time = measureTime {
        Observable.range(1,10)
            .subscribe {
                runBlocking { delay(200) }
                println("Observable1 Item Received $it")
            }
        Observable.range(21,10)
            .subscribe {
                runBlocking { delay(100) }
                println("Observable2 Item Received $it")
            }
    }
    println(time.inWholeMilliseconds)
    println("---------------------")

     time = measureTime {
        Observable.range(1,10)
            .subscribeOn(Schedulers.computation())
            .subscribe {
                runBlocking { delay(200) }
                println("Observable1 Item Received $it")
            }
        Observable.range(21,10)
            .subscribeOn(Schedulers.computation())
            .subscribe {
                runBlocking { delay(100) }
                println("Observable2 Item Received $it")
            }
         runBlocking { delay(2100) }//(3)
    }
    println(time.inWholeMilliseconds)
}

/**
 * Time taken is 3161ms
 * The total execution time of this program would be around 3,100 milliseconds (as the delay
 * is performed before printing), while the thread pool was sitting idle in between. Using
 * scheduler, this time can be significantly reduced
 *
 *
 * ----------
 *
 * Observable in this example is emitted concurrently. The line of the
 * subscribeOn(Schedulers.computation()) code enabled both downstreams to
 * subscribe to the Observable in a different (background) thread, which influenced
 * concurrency. You should already be used to it with using it runBlocking { delay(2100)
 * } on comment (3); we use it to keep the program alive. As all the operations are being
 * performed in different threads, we need to block the main thread to keep the program alive.
 * However, notice the time duration of the delay we passed; it's only 2,100 milliseconds, and
 * the output confirms both the subscriptions processed all the emissions. So, it's clear, we
 * saved 1,000 milliseconds right away.
 * */