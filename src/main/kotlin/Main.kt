import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.disposables.Disposable
import io.reactivex.rxkotlin.subscribeBy

fun main() {
    val observable: Observable<Int> = Observable.range(1, 5)//1

    observable.subscribeBy(onError = {
        println("Error ${it.message}")
    }, onNext = {
        println("Next $it")
    }, onComplete = {
        println("Done")
    })
    val observer: Observer<Int> = object : Observer<Int> {
        //3
        override fun onComplete() {
            println("All Completed")
        }

        override fun onNext(item: Int) {
            println("Next $item")
        }

        override fun onError(e: Throwable) {
            println("Error Occurred ${e.message}")
        }

        override fun onSubscribe(d: Disposable) {
            println("New Subscription ")
        }
    }
    observable.subscribe(observer)
}
