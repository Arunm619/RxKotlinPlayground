import io.reactivex.Observable

fun main() {
    Observable
        .just(1, 2, 3, 4, 5)
        .map { it / (3 - it) }
        .subscribe {
            println("Received $it")
        }
}

/**
 *
 * As expected, the program threw an error and that is a bad thing if that occurs on the user
 * end. So, let's take a look at how we can handle errors in a reactive way. RxKotlin provides
 * us with a few operators for error handling, which we'll take a look at. We will use the
 * previous program and apply various error handling operators to them to understand them
 * better
 *
 *
 * The exception was not handled due to missing onError handler in the subscribe() method call.
 * Always add the onError handler.
 * */