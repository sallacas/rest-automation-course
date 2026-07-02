package questions;

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class StatusCode implements Question<Integer> {
    @Override
    public Integer answeredBy(Actor actor) {
        int statusCode = SerenityRest.lastResponse().getStatusCode();
        System.out.println("Status code: " + statusCode);
        return statusCode;
    }
    public static StatusCode is() {
        return new StatusCode();
    }
}
