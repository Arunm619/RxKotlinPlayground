import io.reactivex.Flowable
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import java.util.concurrent.TimeUnit

fun main() {
    val flowable = Flowable.interval(1000, TimeUnit.MILLISECONDS)//(1)
        flowable.map { it }
        .subscribe { println(it) }
    runBlocking { delay(10000) }
}


/*
Operators help us leverage and express business logic and behaviors. There are a lot of
operators available with RxKotlin. Throughout this book, we will be covering various types
of operators comprehensively so that you know when to use which operator.
Remember, to implement business logic and behavior in your applications, you should use
operators instead of writing blocking code or mixing imperative programming with
reactive programming.

By keeping algorithms and processes purely reactive, you can easily
- leverage lower memory usage,
- flexible concurrency,
- disposability, which are reduced
or not achieved if you mix reactive programming with imperative programming*/
