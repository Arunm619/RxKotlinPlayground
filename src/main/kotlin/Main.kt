import io.reactivex.subjects.BehaviorSubject
import io.reactivex.subjects.PublishSubject

/**
 * AsyncSubject
 * PublishSubject
 * BehaviorSubject
 * ReplaySubject
 * */
fun main() {
    val subject = PublishSubject.create < Int >()
    subject.onNext(1)
    subject.onNext(2)
    subject.onNext(3)
    subject.onNext(4)
    subject.subscribe({
        //onNext
        println("S1 Received $it")
    }, {
        //onError
        it.printStackTrace()
    }, {
        //onComplete
        println("S1 Complete")
    })
    subject.onNext(5)
    subject.subscribe({
        //onNext
        println("S2 Received $it")
    }, {
        //onError
        it.printStackTrace()
    }, {
        //onComplete
        println("S2 Complete")
    })
    subject.onComplete()
}
