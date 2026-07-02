package questions;

import io.restassured.path.json.JsonPath;
import lombok.RequiredArgsConstructor;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

@RequiredArgsConstructor
public class ResponseField implements Question<String> {
    private final String field;
    @Override
    public String answeredBy(Actor actor) {
        String response = SerenityRest.lastResponse().asString();
        JsonPath jsonPath = new JsonPath(response);
        String value = jsonPath.getString(field);
        System.out.println("Value of field '" + field + "': " + value);
        return value;
    }
    public static ResponseField from(String field) {
        return new ResponseField(field);
    }
}
