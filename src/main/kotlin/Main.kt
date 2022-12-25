import io.reactivex.Observable

fun main(args: Array<String>) {
    println("startWith Iterator")
    Observable.range(5,10)
        .startWith(listOf(1,2,3,4))//(1)
        .subscribe {
            println("Received $it")
        }
    println("startWith another source Producer")
    Observable.range(5,10)
        .startWith(Observable.just(1,2,3,4))//(2)
        .subscribe {
            println("Received $it")
        }
}

/**
We can pass another source Observable or an Iterator instance to be prepended before
the source Observable that the operator has subscribed to starts emitting.
In the preceding program, on comment (1), we used the startWith operator and passed
an Interator instance to it. The startWith operator internally converts the passed
Iterator instance to an Observable instance (it'll convert it to a Flowable instance in
case you're using Flowable). Here is the signature of the startWith operator:
fun startWith(items: Iterable<T>): Observable<T> {
return concatArray<T>(fromIterable<out T>(items), this)
}
 * */