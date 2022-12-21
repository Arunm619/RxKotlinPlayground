import io.reactivex.Observable
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.subjects.AsyncSubject

/**
 * AsyncSubject
 * PublishSubject
 * BehaviorSubject
 * ReplaySubject
 * */
fun main() {
    asyncSubjectOnlyExample()
}

/**
 * AsyncSubject only emits the last value of the source observable (Observable it listens
 * on), and the last emission only. To say things more clearly, AsyncSubject will emit the last
 * value it got, and will emit it only one time.
 * */
fun asyncSubject() {
    val observable = Observable.just(1, 2, 3, 4)//1
    val subject = AsyncSubject.create<Int>()//2
    observable.subscribe(subject)//3
    subject.subscribeBy(onNext = {//4
        println("Received $it")
    }, onError = {
        it.printStackTrace()
    }, onComplete = {
        println("Complete")
    })
    subject.onComplete()//5
}

fun asyncSubjectOnlyExample() {
    val subject = AsyncSubject.create<Int>()
    subject.onNext(1)
    subject.onNext(2)
    subject.onNext(3)
    subject.onNext(4)
    subject.subscribe({
        //onNext
        println("S1 Received $it")
    },{
        //onError
        it.printStackTrace()
    },{
        //onComplete
        println("S1 Complete")
    })
    subject.onNext(5)
    subject.subscribe({
        //onNext
        println("S2 Received $it")
    },{
        //onError
        it.printStackTrace()
    },{
        //onComplete
        println("S2 Complete")
    })
    //have to trigger onComplete
    subject.onComplete()
}
