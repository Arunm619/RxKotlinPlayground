import io.reactivex.Observable
import io.reactivex.rxkotlin.toObservable
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import java.util.concurrent.TimeUnit

fun main(args: Array<String>) {
    val observable1 = Observable.interval(500,
        TimeUnit.MILLISECONDS).map { "Observable 1 $it" }//(1)
    val observable2 = Observable.interval(100,
        TimeUnit.MILLISECONDS).map { "Observable 2 $it" }//(2)
    Observable
        .merge(observable1,observable2)
        .subscribe {
            println("Received $it")
        }
    runBlocking { delay(1500) }
}

/**
 * The zipping operation will let you accumulate emissions, but what if you want to subscribe
 * to each emission by all the source producers? Say you have two different producers and
 * have the same set of actions to be applied when subscribing to them; there's no way to mix
 * imperative programming and reactive programming and repeatedly subscribe to both of
 * the producers separately with the same code. It'll also result in redundant code. So, what is
 * the solution here? You got it right; merging all the emissions of all the source producers
 * together and subscribing to them as a whole is the solution.
 *
 * */