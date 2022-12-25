import io.reactivex.Flowable

fun main() {
    val flowable = Flowable.range(1, 111)//(1)
    flowable.window(10)
        .subscribe { flo ->
            flo.subscribe {//(2)
                print("$it, ")
            }
            println()
        }
}