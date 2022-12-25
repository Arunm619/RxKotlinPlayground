import io.reactivex.rxkotlin.toObservable

fun main(args: Array<String>) {
    val observable1 = listOf("Kotlin", "Scala",
        "Groovy").toObservable()
    val observable2 = listOf("Python", "Java", "C++",
        "C").toObservable()
    observable1
        .mergeWith(observable2)
        .subscribe {
            println("Received $it")
        }
}