/**
 * The Schedulers.computation() is probably the most useful scheduler for programmers.
 * It provides us with a bounded thread-pool, which can contain a number of threads equal to
 * the number of available CPU cores. As the name suggests, this scheduler is meant for CPU
 * intense works.
 * We should use this scheduler only for CPU—intense tasks and not for any other cause. The
 * reason is that the threads in this scheduler keeps the CPU cores busy, and may slow down
 * the entire application if it is used for I/O bound or any other tasks that involves noncomputational tasks.
 * The main reason why we should consider Schedulers.io() for I/O bound tasks and
 * Schedulers.computation() for computational purposes is that computation() threads
 * utilize the processors better and create no more threads than the available CPU cores, and
 * reuses them. While Schedulers.io() is unbounded, and if you schedule 10,000
 * computational tasks on io() in parallel, then each of those 10,000 tasks each have their own
 * thread and be competing for CPU incurring context switching costs.
 * */