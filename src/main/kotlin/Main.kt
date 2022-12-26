import io.reactivex.Observable
import io.reactivex.rxkotlin.subscribeBy

fun main(args: Array<String>) {
    Observable.just(1,2,3,4,5)
        .map { it/(3-it) }
        .retry(3)//(1)
        .subscribeBy (
            onNext = {println("Received $it")},
            onError = {println("Error")}
        )
    println("\n With Predicate \n")
    var retryCount = 0
    Observable.just(1,2,3,4,5)
        .map { it/(3-it) }
        .retry {//(2)
                _, _->
            (++retryCount)<3
        }
        .subscribeBy (
            onNext = {println("Received $it")},
            onError = {println("Error")}
        )
}
/**
 * The retry operator is another error handling operator that enables you to retry/resubscribe to the same producer when an error occurs. You just need to provide a predicate
 * or retry-limit when it should stop retrying.
 *
 * we used the retry operator with a retry limit, and on comment (2), we
 * used the retry operator with a predicate. The retry operator will keep retrying until the
 * predicate returns true and will pass the error to downstream whenever the predicate
 * returns false.
 * */