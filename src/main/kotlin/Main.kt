import io.reactivex.rxkotlin.toObservable
import io.reactivex.schedulers.Schedulers
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

fun main() {
    listOf("1", "2", "3", "4", "5", "6", "7", "8", "9", "10")
        .toObservable()
        .observeOn(Schedulers.computation())
        .map { item ->
            println("Mapping $item ${Thread.currentThread().name}")
            return@map item.toInt()
        }
        .observeOn(Schedulers.io())
        .subscribe { item ->
            println("Received $item${Thread.currentThread().name}")
        }
    runBlocking {
        delay(1000)
    }
}
/**
 * While subscribeOn looks like an awesome gift from heaven, it may not be suited in some
 * cases. For example, you may want to do computations on the computation threads and
 * display the results from the io threads, which actually you should do.
 *
 * The subscribeOn operator requires a companion for all these things; while it'll specify the thread for the
 * entire subscription, it requires its companion to specify threads for specific operators.
 *
 * The perfect companion to the subscribeOn operator is the observeOn operator. The
 * observeOn operator specifies the scheduler for all the operators called after it.
 *
 *
 * So, what did we do? We specified the computation threads for the map operator by calling
 * observeOn(Schedulers.computation()) just before it, and called
 * observeOn(Schedulers.io()) before subscribe to switch to io threads to receive the
 * results.
 * In this program, we did a context switch; we exchanged data with threads and
 * implemented communication in between threads with such an ease, with merely 7-8 lines of
 * code—that's the abstraction schedulers provides us with.
 * */