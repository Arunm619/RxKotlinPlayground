fun highOrderFunc(a: Int, validityCheckFunc: (a: Int) -> Boolean) {//(1)
    if (validityCheckFunc(a)) {//(2)
        println("a $a is Valid")
    } else {
        println("a $a is Invalid")
    }
}

fun Int.isEven() = this.mod(2) == 0
fun main() {
    highOrderFunc(12) { a: Int -> a.isEven() }//(3)
    highOrderFunc(19) { a: Int -> a.isEven() }
}