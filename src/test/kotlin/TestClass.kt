import io.reactivex.Observable
import io.reactivex.rxkotlin.toObservable
import io.reactivex.schedulers.Schedulers
import org.junit.jupiter.api.Test
import java.util.concurrent.atomic.AtomicInteger
import kotlin.test.assertEquals

class TestClass {
    @Test
    fun `test with blockingFirst`() {
        val observable = listOf(2,10,5,6,9,8,7,1,4,3).toObservable()
            .sorted()
        val firstItem = observable.blockingFirst()
        assertEquals(1,firstItem)
    }

    /**
     * we created an unsorted list of integers from 1 to 10 and created an
     * Observable with the list, so the smallest item from that Observable should be 1. We
     * obtained the first item and made the thread to wait till we get it with the help of
     * the blockingFirst() operator.
     * */
}