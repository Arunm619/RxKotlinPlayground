import io.reactivex.Observable
import io.reactivex.functions.BiFunction
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import java.util.concurrent.TimeUnit

fun main(args: Array<String>) {
    val observable1 =
        Observable.interval(100, TimeUnit.MILLISECONDS)//(1)
    val observable2 =
        Observable.interval(250,TimeUnit.MILLISECONDS)//(2)
    Observable.combineLatest(observable1,observable2
    ) { t1: Long, t2: Long -> "t1: $t1, t2: $t2" }// (3)
        .subscribe{
            println("Received $it")
        }
    runBlocking { delay(1100) }
}

/**
 * The combineLatest operator processes and emits the value as soon
 * as it gets an emit from any of its source producers by using the last emitted value for all
 * other source producers.
 *
 * */