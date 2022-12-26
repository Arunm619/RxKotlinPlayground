import io.reactivex.Maybe
import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.rxkotlin.toObservable
import io.reactivex.schedulers.Schedulers
import org.junit.jupiter.api.Test
import java.util.concurrent.atomic.AtomicInteger
import kotlin.test.assertEquals

class TestClass {
    @Test
    fun `test Single with blockingGet`() {
        val observable = listOf(2,10,5,6,9,8,7,1,4,3).toObservable()
            .sorted()
        val firstElement: Single<Int> = observable.first(0)
        val firstItem = firstElement.blockingGet()
        assertEquals(1,firstItem)
    }
    @Test
    fun `test Maybe with blockingGet`() {
        val observable = listOf(2,10,5,6,9,8,7,1,4,3).toObservable()
            .sorted()
        val firstElement: Maybe<Int> = observable.firstElement()
        val firstItem = firstElement.blockingGet()
        assertEquals(1,firstItem)
    }
    /**
     * In the first test case, we used observable.first() with a default value, this operator
     * returns a Single; on the second operator, we used observable.firstElement() this
     * operator returns a Maybe. Then we used blockingGet in both test cases to get the first
     * element as an Int and execute the test function.
     * */
}