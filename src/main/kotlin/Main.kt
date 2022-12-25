import io.reactivex.Observable
import io.reactivex.rxkotlin.subscribeBy

fun main(args: Array<String>) {
    Observable.just(1,2,3,5,6,7,"Errr",8,9,10)
        .map { it.toIntOrError() }
        .subscribeBy (
            onNext = {
                println("Next $it")
            },
            onError = {
                println("Error $it")
            }
        )
}

fun Any?.toIntOrError() : Int {
     if(this is Int) return this else throw Exception("WTF bro, pass an int.")
}

/**
The program throws an exception in the map operator when the string Errr is emitted from
the Observable. The exception was caught by the onError handler, but the Subscription
doesn't get any further emissions.
This may not be the desired behavior every time. Although we cannot pretend the error
never happened and continue (we should not do this either), there should be a way to at
least resubscribe or switch to an alternate source producer.
 * */

/**
 * onErrorResumeNext( )
 * onErrorReturn( )
 * onExceptionResumeNext( )
 * retry( )
 * retryWhen()
 * */