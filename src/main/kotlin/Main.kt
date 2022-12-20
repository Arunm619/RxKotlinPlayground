import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlin.system.measureTimeMillis

suspend fun longRunningTsk():Long {//(1)
   val time = measureTimeMillis {//(2)
      println("Please wait")
      delay(2000)//(3)
      println("Delay Over")
   }
   return time
}
fun main() {
   runBlocking {
      var sum = 0L//(4)
      val times = 30
     repeat(times) {
        val exeTime = longRunningTsk()//(5)
        println("Execution Time is $exeTime")
        sum += exeTime
     }
      println("The total average duration is ${sum/times}")
   }
}