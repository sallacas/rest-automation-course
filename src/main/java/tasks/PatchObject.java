package tasks;

import lombok.RequiredArgsConstructor;
import model.ResponseDTO;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.interactions.Patch;

import static utils.Constants.PATH_OBJECT_ID;

@RequiredArgsConstructor
public class PatchObject implements Task {
    private final String id;
    private final ResponseDTO object;
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Patch.to(PATH_OBJECT_ID)
                        .with(request -> request
                                .pathParam("id", id)
                                .body(object)
                                .log().all())
        );
        SerenityRest.lastResponse().prettyPrint();
    }
    public static PatchObject with(String id, ResponseDTO object) {
        return Tasks.instrumented(PatchObject.class, id, object);
    }
}
