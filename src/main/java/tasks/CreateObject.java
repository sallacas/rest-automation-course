package tasks;

import lombok.RequiredArgsConstructor;
import model.ResponseDTO;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.interactions.Post;

import static utils.Constants.PATH_OBJECTS;

@RequiredArgsConstructor
public class CreateObject implements Task {
    private final ResponseDTO object;
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Post.to(PATH_OBJECTS).with(request -> request.body(object).log().all())
        );
        SerenityRest.lastResponse().prettyPrint();
    }
    public static CreateObject with(ResponseDTO object) {
        return Tasks.instrumented(CreateObject.class, object);
    }
}
