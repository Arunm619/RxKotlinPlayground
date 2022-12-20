import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.disposables.Disposable
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import java.util.concurrent.TimeUnit

fun main() {
    runBlocking {
        val observable: Observable<Long> =
            Observable.interval(300, TimeUnit.MILLISECONDS)//1
        val observer: Observer<Long> = object : Observer<Long> {
            lateinit var disposable: Disposable//2
            override fun onSubscribe(d: Disposable) {
                disposable = d//3
            }
            override fun onNext(item: Long) {
                println("Received $item")
                if(item>=100 && !disposable.isDisposed) {//4
                    disposable.dispose()//5
                    println("Disposed")
                }
            }
            override fun onError(e: Throwable) {
                println("Error ${e.message}")
            }
            override fun onComplete() {
                println("Complete")
            }
        }
        observable.subscribe(observer)
        delay(15000)//6
    }
}