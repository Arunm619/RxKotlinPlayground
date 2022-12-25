import io.reactivex.rxkotlin.toObservable

fun main(args: Array<String>) {
    val observable = listOf(10, 9, 8, 7, 6, 5, 4, 3, 2, 1).toObservable()
    observable.map {//(1)
            number ->
        "Transforming Int to String $number"
    }.subscribe { item ->
        println("Received $item")
    }
}

/*
We have already seen a little use of the map operator. For a given
Observable<T> or Flowable<T>, the map operator will transform an emitted item of type
T into an emission of type R by applying the provided lambda of Function<T,R> to it.
*/