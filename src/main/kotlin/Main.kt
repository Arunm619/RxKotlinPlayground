import io.reactivex.Observable

fun main() {
    Observable
        .just(1, 2, 3, 4, 5)
        .map { it / (3 - it) }
        .onErrorReturn { -1 }//(1)
        .subscribe {
            println("Received $it")
        }
}

/**
 *
 * The onErrorReturn operator returns the specified default
 * value. The downstream didn't receive any item further as the upstream stopped emitting
 * items as soon as the error occurred.
 *
 * (i) both onError and onComplete are terminal
 * operators, so the downstream stops listening to that upstream as soon as it
 * receives any of them.
 * */