package ws;

import io.qameta.allure.Step;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.core.StringContains.containsString;

public class PetStoreTest {

    public static final String GET_PET_STORE_REQUEST = "https://petstore.swagger.io/v2/pet";
    public static final String GET_PET_STORE_FIND_BY_STATUS_REQUEST = "/findByStatus?status=available";

    private RequestSpecification spec;

    @BeforeEach
    public void initSpec(){

        spec = new RequestSpecBuilder()
                .setContentType(ContentType.JSON)
                .setBaseUri(GET_PET_STORE_REQUEST)
                .log(LogDetail.ALL)
                .build();
    }

    @Test
    @Step("Check Find By Status item")
    public void checkFindByStatusResponse() {

        given()
                .spec(spec)
                .when()
                .get(GET_PET_STORE_FIND_BY_STATUS_REQUEST)
                .then()
                .log()
                .all()
                .statusCode(200)
                .body(containsString("fish"));
    }
}
