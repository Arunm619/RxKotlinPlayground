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

/**
 * While blockingSubscribe is useful in testing, it cannot always serve your purpose. You
 * might need to test the first, last or all the values of the producer. For that purpose you
 * would need the data in its pure imperative nature.
 * The set of yet uncovered operators in RxKotlin is at your helm in that scenario. The
 * blocking operators serve as an immediate accessible bridge between the reactive world and
 * the imperative world. They block the current thread and make it wait for the results to be
 * emitted, but returns them in a non-reactive way.
 * The only similarity between blockingSubscribe and blocking operators are that both
 * block the declaring thread even if the reactive operations are performed in a different
 * thread.
 *
 *
 *  The blockingSubscribe treats the data
 * as reactive and doesn't return anything. It rather pushes them to the subscriber (or lambda)
 * specified. Whereas blocking operators will return the data in a non-reactive nature.
 * The following list contains the blocking operators we are going to cover:
 * blockingFirst()
 * blockingGet()
 * blockingLast()
 * blockingIterable()
 * blockingForEach()
 * */