import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.disposables.Disposable
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import java.util.concurrent.TimeUnit

fun main(args: Array<String>) {
    val observer: Observer<Any> = object : Observer<Any> {
        override fun onComplete() {
            println("All Completed")
        }

        override fun onNext(item: Any) {
            println("Next $item")
        }

        override fun onError(e: Throwable) {
            println("Error Occured ${e.message}")
        }

        override fun onSubscribe(d: Disposable) {
            println("New Subscription $d")
        }
    }//Create Observer
    Observable.range(1, 10).subscribe(observer)//(1)
    Observable.empty<String>().subscribe(observer)//(2)
    runBlocking {
        //doesn't complete forever, sends number out every x period.
        //Observable.interval(), emits numbers
        //sequentially starting from 0, after each specified interval. It will continue emitting until you
        //unsubscribe and until the program runs
        Observable.interval(300, TimeUnit.MILLISECONDS).subscribe(observer)//(3)
        delay(900)


        //simply completes after delay 400.
        //Observable.timer(), will emit only once with 0 after the specified time elapsed.
        Observable.timer(400, TimeUnit.MILLISECONDS).subscribe(observer)//(4)
        delay(9000)
    }
}