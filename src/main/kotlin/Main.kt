import io.reactivex.BackpressureStrategy
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

fun main() {
    val source = Observable.range(1, 1000)//(1)
    source.toFlowable(BackpressureStrategy.BUFFER)//(2)
        .map { MyItem7(it) }
        .observeOn(Schedulers.io())
        .subscribe {//(3)
            print("Rec. $it;\t")
            runBlocking { delay(1000) }
        }
    runBlocking { delay(100000) }
}

data class MyItem7(val id: Int) {
    init {
        print("MyItem init $id")
    }
}