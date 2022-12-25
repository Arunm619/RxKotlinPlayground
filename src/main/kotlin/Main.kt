import io.reactivex.Observable

fun main(args: Array<String>) {
    val observable1 = Observable.range(1,10)
    val observable2 = Observable.range(11,10)
    Observable.zip(observable1,observable2) { emissionO1, emissionO2 ->
        emissionO1 + emissionO2
    }.subscribe {
        println("Received $it")
    }
}

/**
In order to understand and use the zip operator better, you need to keep the following
points about it in mind:
- The zip operator works on each emission of the supplied producers. For
example, if you pass three producers x, y, and z to the zip operator, it will
accumulate the n
th emission of x with the n
th emission of y and z.
- The zip operator waits for each of its producers to emit, before applying the
function to them. For example, if you use Observable.interval as one of the
producers in the zip operator, the zip operator will wait for each emission and
will emit the accumulated values at the specified intervals as well.
- If any of the producers notify onComplete or onError without emitting the item
it was waiting for, then it'll discard all emissions afterwards, including that
particular one from other producers as well. For example, if producer x emits 10
items, producer y emits 11 items, and producer z emits 8 items, the zip operator
will accumulate the first 8 emissions from all the producers and will discard all
remaining emissions from producer x and y.

 */