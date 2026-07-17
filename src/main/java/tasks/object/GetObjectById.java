package tasks.object;

import lombok.RequiredArgsConstructor;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.interactions.Get;

import static utils.Constants.PATH_OBJECT_ID;

@RequiredArgsConstructor
public class GetObjectById implements Task {
    private final String id;
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Get.resource(PATH_OBJECT_ID)
                        .with(request -> request.pathParam("id", id)
                                .log().all())
        );
        SerenityRest.lastResponse().prettyPrint();

    }
    public static GetObjectById withId(String id) {
        return Tasks.instrumented(GetObjectById.class, id);
    }
}
