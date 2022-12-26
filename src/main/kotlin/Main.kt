import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

fun main() {
    Observable.range(1, 10)
        .map {
            println("map - ${Thread.currentThread().name} $it")
            it
        }
        .subscribeOn(Schedulers.computation())
        .observeOn(Schedulers.io())
        .subscribe {
            println("onNext - ${Thread.currentThread().name} $it")
        }
    runBlocking { delay(100) }
}

/**
 * Need for composing operators with transformers:
 *
 * think of a situation when you want to create a new operator by combining multiple operators. For instance, I often
 * wanted to combine the functionality of the subscribeOn and observeOn operators so that
 * all the computations can be pushed to computation threads, and, when the results are
 * ready, we can receive them on the main thread.
 *
 * Now, say we have this combination of the subscribeOn and observeOn operator
 * throughout our project, so we want a shortcut. We want to create our own operator where
 * we would pass the two Scheduler's where we want subscribeOn and observeOn, and
 * everything should work perfectly.
 * */