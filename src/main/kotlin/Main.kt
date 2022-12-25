import io.reactivex.Observable

fun main(args: Array<String>) {
    val observable = Observable.range(1,30)
    observable.groupBy {//(1)
        it%5
    }.blockingSubscribe {
        //An Observable that has been grouped by key, the value of which can be obtained with getKey().
        // (2)
        println("Key ${it.key} ")
        it.subscribe {//(3)
            println("Received $it")
        }
    }
}

/**
 * Grouping is a powerful operation that can be achieved using RxKotlin. This operation
 * allows you to group emissions based on their property. Say, for example, you have an
 * Observable / Flowable emitting integer numbers (Int), and, as per your business logic,
 * you have some separate code for even and odd numbers and want to handle them
 * separately. Grouping is the best solution in that scenario.
 *
 * */