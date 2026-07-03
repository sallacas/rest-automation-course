package tasks;

import lombok.RequiredArgsConstructor;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.interactions.Delete;

import static utils.Constants.PATH_OBJECT_ID;

@RequiredArgsConstructor
public class DeleteObject implements Task {
    private final String id;

    public static DeleteObject withId(String id) {
        return Tasks.instrumented(DeleteObject.class, id);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Delete.from(PATH_OBJECT_ID).with(request -> request
                        .pathParam("id", id)
                        .log().all())
        );
        SerenityRest.lastResponse().prettyPrint();
    }
}
