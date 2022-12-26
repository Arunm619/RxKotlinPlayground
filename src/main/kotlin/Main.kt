/**
 * The Schedulers.newThread() provides us with a scheduler that creates a new thread for
 * each task provided. While at first glance it may seem similar to Schedulers.io(), there's
 * actually a huge difference.
 *
 * The Schedulers.io() uses a thread pool, and whenever it gets a new unit of work, it first
 * looks into the thread pool to see if any idle thread is available to take up the task; it
 * proceeds to create a new thread if no pre-existing thread is available to take up the work.
 * However, Schedulers.newThread() doesn't even use a thread pool; instead, it creates a
 * new thread for every request and forgets them forever.
 *
 * In most of the cases, when you're not using Schedulers.computation(), you should
 * consider Schedulers.io() and should predominantly avoid using
 * Schedulers.newThread(); threads are very expensive resources, you should try to avoid
 * the creation of new threads as much as possible.
 * */