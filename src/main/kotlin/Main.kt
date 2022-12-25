import io.reactivex.Observable
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.rxkotlin.toObservable

fun main() {
    val observable = listOf(10, 9, 8, 7, 6, 5, 4, 3, 2, 1).toObservable()
    observable.flatMap { number ->
        Observable.create<String> {//(1)
            it.onNext("The Number $number")
            it.onNext("number/2 ${number / 2}")
            it.onNext("number%2 ${number % 2}")
            it.onComplete()//(2)
        }
    }.subscribeBy(onNext = { item ->
        println("Received $item")
    }, onComplete = {
        println("Complete")
    })
}