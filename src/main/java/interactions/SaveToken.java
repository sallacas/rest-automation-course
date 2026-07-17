package interactions;

import io.restassured.path.json.JsonPath;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;

@Slf4j
@NoArgsConstructor
public class SaveToken implements Interaction {
    @Override
    public <T extends Actor> void performAs(T actor) {
        String response = SerenityRest.lastResponse().asString();
        JsonPath jsonPath = new JsonPath(response);
        String token = jsonPath.getString("token");
        log.info("Token saved: {}", token);
        actor.remember("token", token);
    }
    public static SaveToken fromResponse() {
        return new SaveToken();
    }
}
