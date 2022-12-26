import java.io.Closeable

//Resource management

/**
 *
 * So, what is resource? When developing applications, you may often need to access an API
 * (through an HTTP connection), access a database, read from/write to a file, or you may even
 * need to access any I/O ports/sockets/devices. All these things are considered resources in
 * general.
 * Why do we need to manage/close them? Whenever we are accessing a resource, especially
 * to write, the system often locks it for us, and blocks its access to any other program. If you
 * don't release or close a resource when you're done, system performance may degrade and
 * there may even be a deadlock. Even if the system doesn't lock the resource for us, it w
 * */

class Resource : Closeable {
    init {
        println("Resource Created")
    }

    val data: String = "Hello World"
    override fun close() {
        println("Resource Closed")
    }
}
