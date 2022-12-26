import io.reactivex.Observable

fun main() {
    Observable.just(1,2,3,4,5)
        .map { it/(3-it) }
        .onErrorResumeNext(Observable.range(10,5))//(1)
        .subscribe {
            println("Received $it")
        }
}

/**
 * This operator is especially useful when you want to subscribe to another source producer in
 * case any error occurs.
 * */