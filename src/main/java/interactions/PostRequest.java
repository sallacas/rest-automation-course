package interactions;

import lombok.RequiredArgsConstructor;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.rest.interactions.Post;


@RequiredArgsConstructor
public class PostRequest implements Interaction {
    private final String apiKey;
    private final String path;
    private final Object data;

    public static PostRequest to(String apiKey, String path, Object data) {
        return new PostRequest(apiKey, path, data);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Post.to(path).with(request -> request
                        .header("x-api-key", apiKey)
                        .header("Content-Type", "application/json")
                        .body(data)
                        .log().all())
        );
    }
}
