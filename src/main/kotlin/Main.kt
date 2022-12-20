inline fun doSomeStuff(a: Int = 0) = a + a * a
fun main() {
    for (i in 1..10) {
        println("$i Output ${doSomeStuff(i)}")
    }
}