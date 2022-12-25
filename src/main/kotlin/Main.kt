import io.reactivex.Observable
import io.reactivex.rxkotlin.toObservable
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

fun main() {
    listOf(1, 2, 2, 3, 4, 5, 5, 5, 6, 7, 8, 9, 3, 10)//(1)
        .toObservable()//(2)
        .distinct()//(3)
        .subscribe { println("Received $it") }//(4)
}