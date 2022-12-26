/**
 * The Schedulers.newThread() provides us with a scheduler that creates a new thread for
 * each task provided. While at first glance it may seem similar to Schedulers.io(), there's
 * actually a huge difference.
 *
 * The Schedulers.single() provides us with a scheduler that contains only one thread
 * and returns the single instance for every call. Confused? Let's make it clear. Think of a
 * situation where you need to execute tasks that are strongly
 * sequential—Schedulers.single() is the best available option for you here. As it
 * provides you with only one thread, every task that you enqueue here is bound to be
 * executed sequentially
 * */