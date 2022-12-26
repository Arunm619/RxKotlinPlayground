import io.reactivex.observers.TestObserver
import io.reactivex.rxkotlin.toFlowable
import io.reactivex.rxkotlin.toObservable
import io.reactivex.subscribers.TestSubscriber
import org.junit.jupiter.api.Test

class TestClass {
    @Test
    fun `test with TestObserver`() {
        val list = listOf(2, 10, 5, 6, 9, 8, 7, 1, 4, 3, 12, 20, 15, 16, 19, 18, 17, 11, 14, 13)
        val observable = list.toObservable().sorted()
        val testObserver = TestObserver<Int>()
        observable.subscribe(testObserver)//(1)
        testObserver.assertSubscribed()//(2)
        testObserver.awaitTerminalEvent()//(3)
        testObserver.assertNoErrors()//(4)
        testObserver.assertComplete()//(5)
        testObserver.assertValueCount(20)//(6)
        testObserver.assertValues(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20)//(7)
    }

    @Test
    fun `test with TestSubscriber`() {
        val list = listOf(2, 10, 5, 6, 9, 8, 7, 1, 4, 3, 12, 20, 15, 16, 19, 18, 17, 11, 14, 13)
        val flowable = list.toFlowable().sorted()
        val testSubscriber = TestSubscriber<Int>()
        flowable.subscribe(testSubscriber)//(1)
        testSubscriber.assertSubscribed()//(2)
        testSubscriber.awaitTerminalEvent()//(3)
        testSubscriber.assertNoErrors()//(4)
        testSubscriber.assertComplete()//(5)
        testSubscriber.assertValueCount(20)//(6)
        testSubscriber.assertValues(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20)//(7)
    }
    /**
     * So, here are your two superheroes to make the developers life easy—TestObserver and
     * TestSubscriber. As with Subscriber and Observer, you can use TestSubscriber
     * with Flowables and TestObserver with Observables, everything except that is similar
     * between these two.
     *
     *
     * Let's now understand the test cases.
     * On comment (1), we are subscribing to the
     * Observable/Flowable.
     *
     * On comment (2), we are checking if the Subscription was successful
     * and was only one with the help of the assertSubscribed() test.
     *
     * On comment (3), we are blocking the thread until the Observable/Flowable completes its execution with the
     * awaitTerminalEvent() method. This terminal event can be onComplete or onError as
     * well.
     *
     * On comments (4) and (5), we are checking whether the Observable and/or
     * Flowable has completed successfully without any errors, assertNoErrors() will test
     * whether the Subscription hasn't received any errors and
     *
     * assertComplete() will test whether the producer has completed successfully .
     *
     * On comment (6), we are testing that the total received emission count was 20 (there were 20 items in the list),
     * assertValuesCount() helps us with this objective.
     *
     * On comment (6), with the help of assertValues() we are testing the expected and actual values of each of the emissions in its order.
     * */
}