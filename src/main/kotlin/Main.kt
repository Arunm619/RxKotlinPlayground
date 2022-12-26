/**
 * Schedulers.io() provides us with I/O bound threads. To be more accurate,
 * Schedulers.io() provides you with ThreadPool, which can create an unbounded
 * number of worker threads that are meant to be performing I/O bounded tasks.
 * Now, what exactly does the I/O bounded thread mean? And why are we calling it I/O
 * bounded? Let's inspect.
 * All the threads in this pool are blocking and are meant to perform more I/O operations than
 * computationally intense tasks, giving less load to CPUs, but may take longer due to waiting
 * for I/O. By I/O operations, we mean interactions with file systems, databases, services, or
 * I/O devices.
 * We should be cautious about using this scheduler as it can create an infinite number of
 * threads (until the memory lasts) and can cause OutOfMemory errors.
 * */