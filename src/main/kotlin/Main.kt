fun main(args: Array<String>) {
    val fibonacciSeries = sequence {//(1)
        var a = 0L
        var b = 1L
        yield(a)//(2)
        yield(b)
        while (true) {
            val c = a + b
            yield(c)//(3)
            a = b
            b = c
        }
    }
    println(fibonacciSeries.take(100).joinToString(","))
}