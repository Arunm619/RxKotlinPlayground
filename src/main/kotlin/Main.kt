import io.reactivex.subjects.PublishSubject
import io.reactivex.subjects.Subject

fun main() {
    val subject: Subject<Int> = PublishSubject.create()
    subject.map { isEven(it) }.subscribe { println("The number is ${(if (it) "Even" else "Odd")}") }
    subject.onNext(4)
    subject.onNext(9)
}

fun isEven(it: Int): Boolean {
    return it.mod(2) == 0
}
