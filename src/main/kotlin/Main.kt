import io.reactivex.rxkotlin.toObservable
import io.reactivex.schedulers.Schedulers
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

fun main() {
    listOf("1", "2", "3", "4", "5", "6", "7", "8", "9", "10")
        .toObservable().map { item ->
            println("Mapping $item ${Thread.currentThread().name}")
            return@map item.toInt()
        }
        .subscribeOn(Schedulers.newThread())
        .subscribe { item ->
            println("Received $item${Thread.currentThread().name}")
        }
    runBlocking {
        delay(1000)
    }
}
/**
 * From o/p, it's the threads that are responsible for carrying items from
 * the source all the way to the Subscriber through operators. It may be a single thread
 * throughout the subscription, or it may even be different threads at different levels.
 * By default, the thread in which we perform the subscription is the responsible of bringing
 * all the emissions down to the Subscriber, unless we instruct it otherwise
 * */