package tasks.collection;

import lombok.RequiredArgsConstructor;
import model.ResponseDTO;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.interactions.Post;
import utils.Constants;

@RequiredArgsConstructor
public class CreateCollectionObject implements Task {
    private final String collectionName;
    private final Object data;

    public static CreateCollectionObject with(String collection, Object data) {
        return Tasks.instrumented(CreateCollectionObject.class, collection, data);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        String apiKey = Serenity.environmentVariables().getProperty("x-api-key");
        String path = Constants.COLLECTIONS_PATH.replace("{collectionName}", collectionName);
        actor.attemptsTo(
                Post.to(path).with(request -> request
                        .header("x-api-key", apiKey)
                        .header("Content-Type", "application/json")
                        .header("Authorization", "Bearer " + actor.recall("token"))
                        .body(data)
                        .log().all())
        );
    }
}
