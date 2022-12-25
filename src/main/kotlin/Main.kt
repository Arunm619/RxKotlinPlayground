import io.reactivex.Observable

fun main() {
    Observable.range(1, 20)//(1)
        .filter {//(2)
            it % 2 == 0
        }.subscribe {
            println("Received $it")
        }
}