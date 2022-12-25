import io.reactivex.Observable
import java.util.*
import java.util.concurrent.TimeUnit

fun main() {
    Observable.range(1,10)
        .switchMap {
            val randDelay = Random().nextInt(10)
            if(it%3 == 0)
                Observable.just(it)
            else
                Observable.just(it)
                    .delay(randDelay.toLong(), TimeUnit.MILLISECONDS)
        }
        .blockingSubscribe {
            println("Received $it")
        }
}

/**
 *  instead of adding delay to all the emissions, we emitted all the numbers
 * divisible by 3 without delay, and added a delay to the rest.
 * */

/**
 * When the source Observable emits more than one item consecutively before the
 * switchMap has emitted any of them, switchMap will take the last one and discard any
 * emission that came in between
 * */

// Check this: https://stackoverflow.com/a/38391535