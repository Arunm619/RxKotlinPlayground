import io.reactivex.Observable
import io.reactivex.rxkotlin.toObservable

fun main() {
    val observable: Observable<String> = listOf("String 1", "String 2", "String 3", "String 4").toObservable()//1
    observable.subscribe({//2
        println("Received $it")
    }, {
        println("Error ${it.message}")
    }, {
        println("Done")
    })
    observable.subscribe({//3
        println("Received $it")
    }, {
        println("Error ${it.message}")
    }, {
        println("Done")
    })
}

/*
Cold Observables are passive, they don't emit anything until subscribe is called. Hot
Observables are contrary to Cold Observables; it doesn't need subscriptions to start
emission. While you can compare Cold Observables to CD/DVD recordings, Hot
Observables are like TV channels—they continue broadcasting (emitting) their content,
irrespective of whether anyone is watching (Observing) it or not.
Hot Observables resemble events more than data. The events may carry data with them,
but there is a time-sensitive component where Observers that subscribed lately can miss
out previously emitted data. They are specifically useful for UI events while working with
Android/JavaFX/Swing. They are also very useful in resembling server requests.
*/