import io.reactivex.Flowable
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import java.util.concurrent.TimeUnit

fun main(args: Array<String>) {
    val boundaryFlowable = Flowable.interval(350, TimeUnit.MILLISECONDS)
    val flowable = Flowable.interval(100, TimeUnit.MILLISECONDS)//(1)
    flowable.buffer(boundaryFlowable)//(2)
        .subscribe { println(it) }
    runBlocking { delay(5*1000) }//(3)
}