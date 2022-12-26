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
    fun `test with blockingLast`() {
        val observable = listOf(2,10,5,6,9,8,7,1,4,3).toObservable()
            .sorted()
        val firstItem = observable.blockingLast()
        assertEquals(10,firstItem)
    }
    /**
     * As we are expecting the last emitted item, we are checking equality with 10.
     * */
}