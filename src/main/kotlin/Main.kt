import org.apache.http.impl.nio.client.HttpAsyncClients
import rx.apache.http.ObservableHttp

fun main() {
    val httpClient = HttpAsyncClients.createDefault()//(1)
    httpClient.start()//(2)
    val URL = "https://dummyjson.com/products"
    ObservableHttp.createGet(
        URL, httpClient
    ).toObservable()//(3)
        .flatMap { response ->
            response.content.map { bytes ->
                String(bytes)
            }//(4)
        }.onErrorReturn {//(5)
            "Error Parsing data "
        }.subscribe {
            println(it)//(6)
            httpClient.close()//(7)
        }
}

/**
 * In this program, we used HttpAsyncClients.createDefault() to get an instance of
 * CloseableHttpAsyncClient. Before starting an HTTP request, we first need to start the
 * client. We did this in the code on comment (2), with httpClient.start(). On comment
 * (3), we created a GET request and converted it to an observable of type
 * ObservableHttpResponse, so we used the flatMap operator to get access to the content
 * of the response. Inside the flatMap operator, we used the map operator to convert the byte
 * response into a String on comment (4).
 * */