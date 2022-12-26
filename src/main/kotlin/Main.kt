import io.reactivex.ObservableOperator
import io.reactivex.Observer
import io.reactivex.disposables.Disposable
import java.util.concurrent.atomic.AtomicInteger

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

class AddSerialNumber<T> : ObservableOperator<Pair<Int, T>, T> {
    val counter: AtomicInteger = AtomicInteger()
    override fun apply(observer: Observer<in Pair<Int, T>>): Observer<in T> {
        return object : Observer<T> {
            override fun onComplete() {
                observer.onComplete()
            }
            override fun onSubscribe(d: Disposable) {
                observer.onSubscribe(d)
            }
            override fun onError(e: Throwable) {
                observer.onError(e)
            }
            override fun onNext(t: T) {
                observer.onNext(Pair(counter.incrementAndGet(), t))
            }
        }
    }
}

/**
 * Let's start describing this from the very first feature—the definition of the
 * AddSerialNumber class.
 * This implements the ObservableOperator interface. As per our
 * requirement, we kept the class generic, that is, we specified the Upstream type to be generic T.
 *
 * We used an AtomicInteger as a val property of the class, which should be initialized
 * within the init block (as we are declaring and defining the property within the class, it
 * would be automatically initialized within init while creating instances of the class).
 *
 * That AtomicInteger, counter should increment on each emission and should return the
 * emitted value as the serial number of the emission.
 *
 * Inside the apply method, we created and returned an Observer instance, which would be
 * used to listen to the upstream as described earlier.
 *
 * Basically, every operator passes an Observer to upstream by which it should receive the events.
 *
 * Inside that observer, whenever we receive any event, we echoed that to the Observer
 * downstream (where it is received as a parameter).
 *
 * Inside the onNext event of the Upstream Observer, we incremented the counter, added
 * it as the first element to a Pair instance, added the item we received (as a parameter in
 * onNext) as the second value, and, finally, passed it to the
 * onNext—observer.onNext(Pair(counter.incrementAndGet(),t)) downstream
 * */