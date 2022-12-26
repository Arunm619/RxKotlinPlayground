import io.reactivex.Observable
import io.reactivex.ObservableSource
import io.reactivex.annotations.NonNull

/**
 * RxKotlin provides the Transformer interfaces (ObservableTransformer and
 * FlowableTransformer are two Transformer interfaces) for that purpose. Just like the
 * operator interfaces, it has only one method—apply. The only difference is that here,
 * instead of Observers, you have the Observable. So, instead of operating on individual
 * emits and their items, here, you work directly on the source.
 * */

interface ObservableTransformer<Upstream, Downstream> {
    /**
     * Applies a function to the upstream Observable
    and returns an ObservableSource with
     * optionally different element type.
     * @param upstream the upstream Observable instance
     * @return the transformed ObservableSource instance
     */
    @NonNull
    fun apply(@NonNull upstream: Observable<Upstream>):
            ObservableSource<Downstream>
}

/**
 * The interface signature is almost the same. Unlike the apply method of
 * ObservableOperator, here, the apply method receives Upstream Observable and
 * should return the Observable that should be passed to the Downstream.
 * */