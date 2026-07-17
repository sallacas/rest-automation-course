package tasks.collection;

import interactions.PostRequest;
import lombok.RequiredArgsConstructor;
import model.CreateUser;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;

import static utils.Constants.LOGIN_PATH;

@RequiredArgsConstructor
public class DoLogin implements Task {

    private final CreateUser data;

    public static DoLogin with(CreateUser data) {
        return Tasks.instrumented(DoLogin.class, data);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        String apiKey = Serenity.environmentVariables().getProperty("x-api-key");
        actor.attemptsTo(
                PostRequest.to(apiKey, LOGIN_PATH, data)
        );
    }
}
