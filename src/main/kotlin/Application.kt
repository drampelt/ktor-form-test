import io.ktor.client.HttpClient
import io.ktor.client.engine.apache.Apache
import io.ktor.client.request.forms.MultiPartFormDataContent
import io.ktor.client.request.forms.formData
import io.ktor.client.request.post
import io.ktor.http.Headers
import io.ktor.http.HttpHeaders
import io.ktor.http.content.PartData

suspend fun main() {
    val client = HttpClient(Apache)
    val response = client.post<String>("http://localhost:3000/ktor_test") {
        body = MultiPartFormDataContent(formData {
            append("some_key", "some value")
            append("another_key", "another value")
        })

        // Quick workaround to fix the problem
//        body = MultiPartFormDataContent(listOf(
//            PartData.FormItem("some value", {}, Headers.build { append(HttpHeaders.ContentDisposition, "form-data; name=some_key") }),
//            PartData.FormItem("another value", {}, Headers.build { append(HttpHeaders.ContentDisposition, "form-data; name=another_key") })
//        ))
    }
    println(response)
}
