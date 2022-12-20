import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.disposables.Disposable
import io.reactivex.rxkotlin.toObservable

fun main() {
    val observer: Observer<Any> = object : Observer<Any> {
        override fun onComplete() {
            println("All Completed")
        }

        override fun onNext(item: Any) {
            println("Next $item")
        }

        override fun onError(e: Throwable) {
            println("Error Occurred $e")
        }

        override fun onSubscribe(d: Disposable) {//5
            println("Subscribed to $d")
        }
    }
    val observable: Observable<Any> = listOf("One", 2, "Three", "Four", 4.5, "Five", 6.0f).toObservable() //6
    observable.subscribe(observer)

    val observableOnList: Observable<List<Any>> = Observable.just(
        listOf(
            "One", 2, "Three", "Four", 4.5, "Five", 6.0f
        ), listOf("List with Single Item"), listOf(1, 2, 3, 4, 5, 6)
    )
    observableOnList.subscribe(observer)
}