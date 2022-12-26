import io.reactivex.Observable
import io.reactivex.ObservableSource
import io.reactivex.ObservableTransformer
import io.reactivex.Scheduler
import io.reactivex.schedulers.Schedulers
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

fun main(args: Array<String>) {
    Observable.range(1, 10).map {
        println("map - ${Thread.currentThread().name} $it")
        it
    }.compose(
            SchedulerManager(
                Schedulers.computation(), Schedulers.io()
            )
        ).subscribe {
            println("onNext - ${Thread.currentThread().name} $it")
        }
    runBlocking { delay(100) }
}

class SchedulerManager<T>(
    private val subscribeScheduler: Scheduler,
    private val observeScheduler: Scheduler
) : ObservableTransformer<T, T> {
    override fun apply(upstream: Observable<T>): ObservableSource<T> {
        return upstream
            .subscribeOn(subscribeScheduler)
            .observeOn(observeScheduler)
    }
}