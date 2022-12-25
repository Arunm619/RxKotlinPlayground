import io.reactivex.Observable
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import java.util.concurrent.TimeUnit

fun main(args: Array<String>) {
    val observable1 = Observable.interval(500, TimeUnit.MILLISECONDS)
        .take(2)//(1)
        .map { "Observable 1 $it" }//(2)
    val observable2 = Observable.interval(
        100,
        TimeUnit.MILLISECONDS
    ).map { "Observable 2 $it" }//(3)
    Observable
        .concat(observable1, observable2)
        .subscribe {
            println("Received $it")
        }
    runBlocking { delay(1500) }
}

/**
the concat operator subscribes to the next source Observable
in the queue only after it got onComplete from its current source Observable; we also
know that the Observable instances created with Observable.interval never emit
onComplete. Rather, they keep emitting numbers until Long.MAX_VALUE is reached. So, as
a quick fix, we used the take operator on comment (1), which will take the first two
emissions from Observable.interval and then will append an onComplete notification
to it so that the concat operator can start listening to the next source Observable as well.
 */

/**
 * Just like the merge operator, the concat operator also has concatArray and concatWith
 * variants, and they work in almost the same way, just concatenating instead of merging.
 * */