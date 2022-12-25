import io.reactivex.Flowable
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import java.util.concurrent.TimeUnit

fun main() {
    val flowable = Flowable.interval(100, TimeUnit.MILLISECONDS)//(1)
    flowable.throttleFirst(200, TimeUnit.MILLISECONDS)//(2)
        .subscribe { println(it) }
    runBlocking { delay(10000) }
}