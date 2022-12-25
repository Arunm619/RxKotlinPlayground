import io.reactivex.Observable
import io.reactivex.rxkotlin.subscribeBy

fun main(args: Array<String>) {
    Observable.range(1,10)
        .any { it !is Int }
        .subscribeBy { println("accumulation $it") }
}