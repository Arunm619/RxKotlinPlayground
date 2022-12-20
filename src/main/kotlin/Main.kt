inline fun highOrderFuncInline(a: Int, validityCheckFunc: (a: Int) -> Boolean) {
    if (validityCheckFunc(a)) {
        println("a $a is Valid")
    } else {
        println("a $a is Invalid")
    }
}

fun Int.isEven() = this.mod(2) == 0
fun main() {
    highOrderFuncInline(12) { a: Int -> a.isEven() }
    highOrderFuncInline(19) { a: Int -> a.isEven() }
}