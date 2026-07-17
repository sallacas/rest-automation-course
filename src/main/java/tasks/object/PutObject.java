package tasks.object;

import lombok.RequiredArgsConstructor;
import model.ResponseDTO;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.interactions.Put;

import static utils.Constants.PATH_OBJECT_ID;

@RequiredArgsConstructor
public class PutObject implements Task {
    private final String id;
    private final ResponseDTO data;

    public static PutObject with(String id, ResponseDTO data) {
        return Tasks.instrumented(PutObject.class, id, data);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Put.to(PATH_OBJECT_ID).with(request -> request
                        .pathParam("id", id)
                        .body(data)
                        .log().all())
        );
        SerenityRest.lastResponse().prettyPrint();
    }
}
