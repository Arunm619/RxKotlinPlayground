import io.reactivex.Observable
import io.reactivex.observers.TestObserver
import io.reactivex.schedulers.TestScheduler
import org.junit.jupiter.api.Test
import java.util.concurrent.TimeUnit

class TestClass {
    @Test
    fun `test by fast forwarding time`() {
        val testScheduler = TestScheduler()
        val observable = Observable.interval(5, TimeUnit.MINUTES, testScheduler)
        val testObserver = TestObserver<Long>()
        observable.subscribe(testObserver)
        testObserver.assertSubscribed()
        testObserver.assertValueCount(0)//(1)
        testScheduler.advanceTimeBy(100, TimeUnit.MINUTES)//(2)
        testObserver.assertValueCount(20)//(3)
        testScheduler.advanceTimeBy(400, TimeUnit.MINUTES)//(4)
        testObserver.assertValueCount(100)//(5)
    }

    /**
     *
     * On comment (1), it should not receive any emissions (as there are still 5 minutes before it
     * should receive its first emission) and we are testing it with assertValuesCount(0).
     *
     * We then fast-forwarded the time by 100 minutes on comment (2), and tested whether we
     * received 20 emissions on comment (3).
     * TestScheduler provides us with the advanceTimeBy method, which takes a timespan and unit as parameters and simulates that
     * for us.
     *
     * We then fast-forwarded time by another 400 minutes and tested if we received a total of 100
     * emissions on comment (4) and comment (5).
     * */
}