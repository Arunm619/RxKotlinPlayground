import io.reactivex.Observable
import io.reactivex.rxkotlin.toObservable

fun main(args: Array<String>) {
    val observable1 = listOf("A", "B", "C").toObservable()
    val observable2 = listOf("D", "E", "F", "G").toObservable()
    val observable3 = listOf("I", "J", "K", "L").toObservable()
    val observable4 = listOf("M", "N", "O", "P").toObservable()
    val observable5 = listOf("Q", "R", "S", "T").toObservable()
    val observable6 = listOf("U", "V", "W", "X").toObservable()
    val observable7 = listOf("Y", "Z").toObservable()
    Observable.mergeArray(observable1, observable2, observable3,
        observable4, observable5, observable6, observable7)
        .subscribe {
            println("Received $it")
        }
}

/**
 * The zipping operation will let you accumulate emissions, but what if you want to subscribe
 * to each emission by all the source producers? Say you have two different producers and
 * have the same set of actions to be applied when subscribing to them; there's no way to mix
 * imperative programming and reactive programming and repeatedly subscribe to both of
 * the producers separately with the same code. It'll also result in redundant code. So, what is
 * the solution here? You got it right; merging all the emissions of all the source producers
 * together and subscribing to them as a whole is the solution.
 *
 * */