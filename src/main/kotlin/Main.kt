import io.reactivex.Flowable
import io.reactivex.schedulers.Schedulers
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

fun main() {
    Flowable.range(1, 1000)//(1)
        .map { MyItem4(it) }//(2)
        .observeOn(Schedulers.io()).subscribe({//(3)
            println("Received $it")
            runBlocking { delay(50) }//(4)
        }, { it.printStackTrace() })
    runBlocking { delay(60000) }//(5)
}

data class MyItem4(val id: Int) {
    init {
        println("MyItem Created $id")
    }
}