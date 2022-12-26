/**
* So, whenever you subscribe to an Observable and/or Flowable, the current thread is
blocked until all the items are emitted and received by the Observer chain (except for the
cases with interval and timer factory methods). Surprising, right? However, it's actually
good, because, for an Observable chain, if a separate thread is assigned to each operator
(any operator generally subscribes to the source Observable and performs operations on the
emissions, the next operator subscribes to the emissions by the current one), then it would
be totally messy.
To resolve this scenario, ReactiveX provided us with scheduler and scheduling operators.
By using them, thread management becomes easy, as the synchronization is almost
automatic and there's no shared data between threads (as a basic property of functional
programming, thus functional reactive programming).
Now that we have got some hands on the ideas behind concurrency, we can move forward
with implementing concurrency using RxKotlin.
*
* In ReactiveX, the heart of concurrency lies in schedulers. As I have already mentioned, by
default, the Observable and the chain of operators applied to it will do the work on the
same thread where subscribe is called, and the thread will be blocked until Observer
receives the onComplete or onError notification. We can use schedulers to change this
behavior.

Types of scheduler
As an abstraction layer for thread pool management, the scheduler API provides you with
some pre-composed scheduler. It also allows you to create a new user-defined scheduler.
Let's take a look at the available scheduler types:
Schedulers.io()
Schedulers.computation()
Schedulers.newThread()
Schedulers.single()
Schedulers.trampoline()
Schedulers.from()
* */