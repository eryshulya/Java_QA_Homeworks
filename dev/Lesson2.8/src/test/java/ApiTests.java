import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import java.util.Collections;
public class ApiTests {
    @Test
    public void getRequestTest() {
        given()
                .when()
                .get("https://postman-echo.com/get?foo1=bar1&foo2=bar2")
                .then()
                .statusCode(200)
                .body("args.foo1", equalTo("bar1"))
                .body("args.foo2", equalTo("bar2"));
    }
    @Test
    public void postRequestTest() {
        given() //что хотим отправить серверу
                .contentType("text/plain")//указываем тип отправляемых данных
                .body("Hello Postman")// что хотим отправить
                .when()//какое действие выполнить с настроенным запросом
                .post("https://postman-echo.com/post")//отправляем запрос на указанный url
                .then()//проверяем полученный ответ
                .statusCode(200)
                .body("data", equalTo("Hello Postman"))//data - данные с response
                .body("args", equalTo(Collections.emptyMap()))
                .body("files", equalTo(Collections.emptyMap()))
                .body("form", equalTo(Collections.emptyMap()));
    }
    @Test
    public void postFormDataRequestTest(){
        given()
                .multiPart("foo1", "bar1")//добавили данные в запрос
                .multiPart("foo2", "bar2")
                .when()
                .post("https://postman-echo.com/post")
                .then()
                .statusCode(200)
                .body("form.foo1", equalTo("bar1"))
                .body("form.foo2", equalTo("bar2"))
                .body("args",equalTo(Collections.emptyMap()))
                .body("data",equalTo(Collections.emptyMap()))
                .body("files",equalTo(Collections.emptyMap()));

    }
    @Test
    public void putRequestTest(){
        given()
                .contentType("text/plain")
                .body("Hello user")
                .when()
                .put("https://postman-echo.com/put")
                .then()
                .statusCode(200)
                .body("data",equalTo("Hello user"))
                .body("args",equalTo(Collections.emptyMap()))
                .body("form",equalTo(Collections.emptyMap()))
                .body("files",equalTo(Collections.emptyMap()));
    }
    @Test
    public void patchRequestTest(){
        given()
                .contentType("text/plain")
                .body("Goodbye user")
                .when()
                .patch("https://postman-echo.com/patch")
                .then()
                .statusCode(200)
                .body("data",equalTo("Goodbye user"))
                .body("args",equalTo(Collections.emptyMap()))
                .body("form",equalTo(Collections.emptyMap()))
                .body("files",equalTo(Collections.emptyMap()));
    }
    @Test
    public void deleteRequestTest(){
        given()
                .contentType("text/plain")
                .body("This is expected to be sent back as part of response body.")
                .when()
                .delete("https://postman-echo.com/delete")
                .then()
                .log().body()
                .statusCode(200)
                .body("data", equalTo("This is expected to be sent back as part of response body."));
    }
}
