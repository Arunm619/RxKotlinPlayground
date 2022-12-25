import io.reactivex.Observable
import io.reactivex.rxkotlin.subscribeBy

fun main(args: Array<String>) {
    Observable.range(1,10)
        .reduce { previousAccumulation, newEmission ->
            previousAccumulation+newEmission }
        .subscribeBy { println("accumulation $it") }
    Observable.range(1,5)
        .reduce { previousAccumulation, newEmission ->
            previousAccumulation*10+newEmission }
        .subscribeBy { println("accumulation $it") }
}
/**
 * The reduce operator works similar to the scan operator, the only difference is that instead
 * of accumulating and emitting them on each emission, it accumulates all the emissions and
 * emits them on receiving the onComplete notification.
 * */