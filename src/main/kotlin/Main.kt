import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.rxkotlin.toObservable

fun main() {
    listOf(1,5,9,7,6,4,3,2,4,6,9).toObservable()
        .count()
        .subscribeBy { println("count $it") }
}

/**
 * The count operator subscribes to a producer, counts the emissions, and emits a Single,
 * containing the count of emissions by the producer.
 * */