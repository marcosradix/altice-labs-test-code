package pt.altice.labs.resource;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

@QuarkusTest
public class LabseqResourceTest {

    @Test
    void labseq_thenShouldReturnSuccessfully() {
        int index = 10;
        int expectedResult = 3;

        given()
                .contentType(ContentType.JSON)
                .when()
                .pathParam("index", index)
                .get("/labseq/{index}")
                .then()
                .statusCode(200)
                .body("data", equalTo(expectedResult));
    }

}
