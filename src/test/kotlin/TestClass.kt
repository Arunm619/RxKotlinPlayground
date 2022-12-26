import io.reactivex.rxkotlin.toObservable
import org.junit.jupiter.api.Test
import kotlin.test.assertTrue

class TestClass {
    @Test
    fun `test with blockingForEach`() {
        val list =
            listOf(2, 10, 5, 6, 9, 8, 7, 1, 4, 3, 12, 20, 15, 16, 19, 18, 17, 11, 14, 13)
        val observable = list.toObservable()
            .filter { item -> item % 2 == 0 }
        observable.blockingForEach { item ->
            assertTrue { item % 2 == 0 }
        }
    }
    /**
     * we created an Observable from a list of Int. Then applied a
     * filter for even numbers only and then within the blockingForEach we are testing whether
     * all the received numbers are even.
     * */
}