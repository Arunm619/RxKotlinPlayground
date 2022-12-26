import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers
import org.junit.jupiter.api.Test
import java.util.concurrent.atomic.AtomicInteger
import kotlin.test.assertEquals

class TestClass {
    @Test//(1)@Test
    fun `check emissions count`() {
        val emissionsCount = AtomicInteger()//(1)
        Observable
            .range(1, 10)
            .subscribeOn(Schedulers.computation())
            .blockingSubscribe {//(2)
                emissionsCount.incrementAndGet()
            }
        assertEquals(10, emissionsCount.get())//(3)
    }

    /**
     * AtomicInteger is a wrapper around integer in Java, that allows an Int value to be
     * updated atomically. Though AtomicInteger extends Number to allow uniform access by
     * tools and utilities that deal with numerically-based classes, it cannot be used as a
     * replacement of Integer. We used AtomicInteger in this code to ensure atomicity, as the
     * subscription was running in the computationScheduler (thus in multiple threads).
     *
     *
     * The line, that demands our attention is where we put comment (2). We used
     * blockingSubscribe instead of just subscribe. When we subscribe to a producer with
     * the subscribe operator and the subscription is not in the current thread, the current thread
     * doesn't wait for the subscription to complete and moves to the next line instantly. That's
     * why we used delay to make the current thread wait. Using delay inside tests is
     * troublesome. While blockingSubscribe blocks the current running thread until the
     * subscription finishes up (even if the subscription occurs in a separate thread), that is useful
     * while writing tests.
     * */
}