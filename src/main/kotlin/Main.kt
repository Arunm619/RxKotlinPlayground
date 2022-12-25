import io.reactivex.Observable
import java.util.*
import java.util.concurrent.TimeUnit

fun main() {
    println("Without delay")
    Observable.range(1,10)
        .switchMap {
            return@switchMap Observable.just(it)//(1)
        }
        .blockingSubscribe {
            println("Received $it")
        }
    println("With delay")
    Observable.range(1,15)
        .switchMap {
            val randDelay = Random().nextInt(10)
            return@switchMap Observable.just(it)
                .also {
                    //println("The value is ${it.blockingSingle()}")
                }
                .delay(randDelay.toLong(), TimeUnit.MILLISECONDS)//(2)
        }
        .blockingSubscribe {
            println("Received $it")
        }
}

/**
 * When the source Observable emits more than one item consecutively before the
 * switchMap has emitted any of them, switchMap will take the last one and discard any
 * emission that came in between
 * */