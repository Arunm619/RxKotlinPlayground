import io.reactivex.Observable
import io.reactivex.rxkotlin.subscribeBy

fun main(args: Array<String>) {
    Observable.just(1, 2, 3, 5, 6, 7, 8, 9, 10)
        .map { it.toIntOrError() }
        .doOnNext {
            println("onNext called. 1")
        }
        .doOnNext {
        println("onNext called. 2")
    }
        .doOnNext {
            println("onNext called. 3")
        }
        .doOnNext {
            println("onNext called. 4")
        }
        .doOnComplete {
            println("onComplete called.")
        }
        .doOnSubscribe {
            println("onSubscribe called.")
        }
        .subscribeBy(onNext = {
        println("Next $it")
    }, onError = {
        println("Error $it")
    }).dispose()
}

fun Any?.toIntOrError(): Int {
    if (this is Int) return this else throw Exception("WTF bro, pass an int.")
}

/**
These operators help us to perform various utility operations, such as performing some
action on emissions, remembering timestamps of each items emitted, caching, and much
more.
The following is the list of utility operators:
doOnNext, doOnComplete, and doOnError
doOnSubscribe, doOnDispose, and doOnSuccess
serialize
cache

 */