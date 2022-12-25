import io.reactivex.Observable
import io.reactivex.rxkotlin.subscribeBy

fun main() {
    Observable.range(1,10)
        .toList()
        .subscribeBy { println(" $it") }
}
/**
 * Though it is not good practice, keeping some rare situations in mind, RxKotlin provides
 * you with operators that can listen to all the emissions and accumulate them to a collection
 * object.
 * The collection operators are basically a subset of the reducing operators.
 * Covered in later chapters.
 * */