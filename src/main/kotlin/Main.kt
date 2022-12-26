import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.disposables.Disposable

fun main() {
    val observable = Observable.range(1,20)
    observable
        .takeWhile{item->item<10}//(1)
        .subscribe(object: Observer<Int> {
            override fun onError(e: Throwable) {
                println("Error $e")
            }
            override fun onComplete() {
                println("Complete")
            }
            override fun onNext(t: Int) {
                println("Received $t")
            }
            override fun onSubscribe(d: Disposable) {
                println("starting skipWhile")
            }
        })
}

/**
 * In the exact opposite way than the skip operator, the take
 * operator passes the specified emissions to downstream, discarding the remaining ones.
 * Most importantly, it also sends onComplete notifications to downstream on its own, as
 * soon as it completes passing all the specified emissions.
 * */