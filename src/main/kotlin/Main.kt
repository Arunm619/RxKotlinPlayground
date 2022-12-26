import io.reactivex.Observable
import io.reactivex.Scheduler
import io.reactivex.schedulers.Schedulers
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import java.util.concurrent.Executor
import java.util.concurrent.Executors

fun main() {
    val executor: Executor = Executors.newFixedThreadPool(2)//(1)
    val scheduler: Scheduler = Schedulers.from(executor)//(2)
    Observable.range(1, 10).subscribeOn(scheduler)//(3)
        .subscribe {
            runBlocking { delay(200) }
            println("Observable1 Item Received $it -${Thread.currentThread().name}")
        }
    Observable.range(21, 10).subscribeOn(scheduler)//(4)
        .subscribe {
            runBlocking { delay(100) }
            println(
                "Observable2 Item Received $it -${Thread.currentThread().name}"
            )
        }
    Observable.range(51, 10).subscribeOn(scheduler)//(5)
        .subscribe {
            runBlocking { delay(100) }
            println(
                "Observable3 Item Received $it -${Thread.currentThread().name}"
            )
        }
    runBlocking { delay(10000) }//(6)
}

/**
 *  we've created a custom Scheduler from an Executor (for the sake of
 * simplicity, we've used a standard Thread Pool Executor; you're free to use your own custom
 * executor).
 * On comment (1), we created the executor with the Executors.newFixedThreadPool()
 * method, on comment (2), we created the scheduler instance with the help of
 * Schedulers.from(executor:Executor). We used the scheduler instance on comment
 * (3), comment (4), and comment (5).
 * */