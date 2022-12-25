import io.reactivex.BackpressureStrategy
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

fun main() {
    val source = Observable.range(1, 129)
    source.toFlowable(BackpressureStrategy.MISSING)//(1)
        .onBackpressureDrop { print("Dropped $it;\t") }//(2)
        .map { MyItem12(it) }.observeOn(Schedulers.io()).subscribe {
            print("Rec. $it;\n")
            runBlocking { delay(100) }
        }
    runBlocking { delay(600000) }
}

data class MyItem12(val id: Int) {
    init {
        print("MyItem init $id;\n")
    }
}