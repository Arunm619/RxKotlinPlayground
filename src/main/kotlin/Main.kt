import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlin.system.measureTimeMillis

suspend fun longRunningTsk(): Long {//(1)
    val time = measureTimeMillis {//(2)
        println("Please wait")
        delay(2000)//(3)
        println("Delay Over")
    }
    return time
}

fun main(args: Array<String>) {
    runBlocking {
        println("aSync GlobalScope")
        var time = measureTimeMillis {
            val a1 = GlobalScope.async {
                delay(1000)
                delay(1000)
            }
            a1.await()
        }
        println("Total time: $time")

    }
}