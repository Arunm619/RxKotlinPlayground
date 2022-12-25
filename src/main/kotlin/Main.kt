import io.reactivex.Observable
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import java.util.concurrent.TimeUnit

fun main(args: Array<String>) {
    val observable1 = Observable.interval(500,
        TimeUnit.MILLISECONDS).map { "Observable 1 $it" }//(1)
    val observable2 = Observable.interval(100,
        TimeUnit.MILLISECONDS).map { "Observable 2 $it" }//(2)
    Observable
        .amb(listOf(observable1,observable2))//(3)
        .subscribe {
            println("Received $it")
        }
    runBlocking { delay(1500) }
}

/**
 * We can see from the output that the amb operator took the emissions from observable2
 * and didn't care about observable1, as the observable2 instance emitted first.
 * Just like other combination operators, amb also has ambArray and ambWith operator
 * variants.
 *
 * */