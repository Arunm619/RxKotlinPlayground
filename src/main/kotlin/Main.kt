import io.reactivex.Observable
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

fun main() {
    Observable.using({//(1) resourceSupplier
        Resource()
    }, {//(2) sourceSupplier
            resource: Resource ->
        Observable.just(resource)
    }, {//(3) disposer
            resource: Resource ->
        resource.close()
    }).subscribe { resource ->
        println("Resource Data ${resource.data}")
    }
}
/**
 * we passed three lambdas to the using operator.
 * In the first lambda (comment one), we created an instance of Resource and returned it (in a lambda,
 * the last statement works as return, you don't have to write it).
 *
 * The second lambda will take resource as parameter and will create the Observable from
 * it to return.
 *
 * The third lambda will again take resource as a parameter and close it.
 *
 * The using operator will return the Observable you created in the second lambda for you
 * to apply the RxKotlin chain to it.
 *
 * */
