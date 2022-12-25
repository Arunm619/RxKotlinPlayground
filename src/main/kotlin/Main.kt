import io.reactivex.Flowable

fun main(args: Array<String>) {
    val flowable = Flowable.range(1,111)//(1)
    flowable.buffer(10,15)//(2)
        .subscribe { println(it) }
}