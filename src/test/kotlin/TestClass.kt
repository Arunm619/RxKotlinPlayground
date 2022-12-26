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
    fun `test with blockingIterable`() {
        val list = listOf(2,10,5,6,9,8,7,1,4,3)
        val observable = list.toObservable()
            .sorted()
        val iterable = observable.blockingIterable()
        assertEquals(list.sorted(),iterable.toList())
    }
    /**
     * The blockingIterable operator works in an interesting way, it passes an emission to the
     * Iterable, then the Iterable will keep blocking the iterating thread until the next
     * emission is available. This operator queues up unconsumed values until the Iterator can
     * consume them, and this can cause OutOfMemory exceptions.
     * */
}