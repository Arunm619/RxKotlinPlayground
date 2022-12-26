/**
The definition of concurrency can be described as follows:
As a programming paradigm, concurrent computing is a form of modular programming,
namely factoring an overall computation into subcomputations that may be executed
concurrently.
– Wikipedia
As the definition says, concurrency is all about breaking the entire task into small parts and
then executing them concurrently (there's a small difference between concurrent execution
and parallel execution, which we will discuss shortly).
So, what does it mean to execute subcomputations concurrently? Let's look at a real-life
example. Think of a situation where you're cooking a new dish at your home and you have
three chores—bring the spices, cut the vegetables, and also marinate something. Now, if
you're doing it all alone, you have to do them one by one, but if you have a family member
at your disposal, then you can distribute the tasks between the two of you. You can cut the
vegetables while the other person is bringing the spices, and whoever between you two
completes early can continue on the third task—marinating the food.
You can think of you and the family member (who helped you) as two threads, or, to be
more specific, you're the main thread of the program (here, cooking) as you're the
responsible person for the entire job, and you'll be distributing tasks between you and the
family member, who is a worker thread. Together, you and your family member form a
thread pool.
The entire program will execute faster if there are more threads and the complete task is
divided properly among them.
 *
 * */