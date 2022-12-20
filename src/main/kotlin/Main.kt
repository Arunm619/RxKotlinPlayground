fun square(n:Int):Int {//(1)
    return n*n
}
fun main() {
    println("named pure func square = ${square(3)}")
    val cube = {n:Int -> n*n*n}//(2)
    println("lambda pure func qube = ${cube(3)}")
}