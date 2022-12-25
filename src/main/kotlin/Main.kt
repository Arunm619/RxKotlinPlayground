import io.reactivex.Observable
import java.util.*
import java.util.concurrent.TimeUnit

fun main() {
    concatMapExample()
    flatMapExample()
}

/**
* Uses concat internally.
* */
fun concatMapExample() {
    Observable.range(1,10)
        .concatMap {
            val randDelay = Random().nextInt(1000)
            return@concatMap Observable.just(it)
                .delay(randDelay.toLong(), TimeUnit.MILLISECONDS)//(1)
        }
        .blockingSubscribe {
            println("Received $it")
        }
}

/**
 * As the concatMap operator uses concat internally, it maintains the prescribed order of
 * emissions.
 * */

/**
 * Uses Merge internally
 * */
fun flatMapExample() {
    Observable.range(1,10)
        .flatMap {
            val randDelay = Random().nextInt(10)
            return@flatMap Observable.just(it)
                .delay(randDelay.toLong(), TimeUnit.MILLISECONDS)//(1)
        }
        .blockingSubscribe {
            println("Received $it")
        }
}
/*
*  the cause
behind it is simply the merge operator, as the merge operator subscribes and reemits the
emissions asynchronously all at one go, thus the order is not maintained.
* */


/**
 * When to use flatMap operator
 * Take a look at the following list—it contains the contexts and situations where flatMap will
 * fit best:
 * When you're working with a list of data within a page, activity, or fragment and
 * want to send some data to a server or a database per item of the list. The
 * concatMap operator will also do here; however, as the flatMap operator works
 * asynchronously, it'll be faster, and, as you're sending data, the order doesn't
 * really matter.
 * Whenever you want to perform any operation on list items asynchronously and
 * in a comparatively short time period.
 * When to use concatMap operator
 * So, when to use concatMap?
 * The following list contains the contexts and situations where concatMap will fit best:
 * When you are downloading the list of data to display to the user. The order really
 * matters here, you will surely not want to load and display the second item of the
 * list after the third and fourth one are already displayed, would you?
 * Performing some operation on a sorted list, making sure the list stays the same
 *
 * */