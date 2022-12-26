/**
 *
 * Schedulers.single() and Schedulers.trampoline() sound somewhat similar, both
 * the schedulers are for sequential execution. While Schedulers.single() guarantees that
 * all its task will run sequentially, it may run parallel to the thread it was called upon (if not,
 * that thread is from Schedulers.single() as well); the Schedulers.trampoline() is
 * different in that sector.
 * */