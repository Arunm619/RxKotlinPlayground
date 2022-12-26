import io.reactivex.Observer
import io.reactivex.annotations.NonNull

/**
 * Requirements of customer operator
 *
 * 1. The operator should emit a pair, with an added sequential number as the first
 * element. The second element of the pair should be the actual emission.
 *
 * 2. The operator should be generic and should work with any type of Observable.
 * 3. As with other operators, the operator should work concurrently with other
 * operators.
 * */

/**
 * The preceding points are our basic requirements; and, as per the preceding requirement, we
 * must use AtomicInteger for the counter (which will count the emissions, and we will pass
 * that count as a sequential number) so that the operator will work seamlessly with any
 * Scheduler.
 * */

/*
Every custom operator should implement the ObservableOperator interface, which looks
like this:

*/
interface ObservableOperator<Downstream, Upstream> {
    /**
     * Applies a function to the child Observer and returns a new
    parent Observer.
     * @param observer the child Observer instance
     * @return the parent Observer instance
     * @throws Exception on failure
     */
    @NonNull
    @Throws(Exception::class)
    fun apply(@NonNull observer: Observer<in Downstream>): Observer<in Upstream>
}