package tasks.collection;

import interactions.PostRequest;
import lombok.RequiredArgsConstructor;
import model.CreateUser;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.interactions.Post;

import static utils.Constants.REGISTER_PATH;

@RequiredArgsConstructor
public class DoRegister implements Task {

    private final CreateUser data;

    public static DoRegister with(CreateUser data) {
        return Tasks.instrumented(DoRegister.class, data);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        String apiKey = Serenity.environmentVariables().getProperty("x-api-key");
        actor.attemptsTo(
                PostRequest.to(apiKey, REGISTER_PATH, data)
        );
    }
}
