package steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.extern.slf4j.Slf4j;
import model.ObjectData;
import model.ResponseDTO;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import org.hamcrest.Matchers;
import questions.ResponseField;
import questions.StatusCode;
import tasks.*;

import java.util.Map;

import static org.hamcrest.Matchers.*;

@Slf4j
public class ApiSteps {

    private final Actor actor = Actor.named("Juan");

    @Given("que Juan puede consumir la API")
    public void queJuanPuedeConsumirLaAPI() {
        String url = Serenity.environmentVariables().getProperty("restapi.baseurl");
        actor.whoCan(
                CallAnApi.at(url)
        );
    }

    @When("consultar el objeto con ID {string}")
    public void consultarElObjetoConID(String id) {
        actor.attemptsTo(
            GetObjectById.withId(id)
        );
    }

    @Then("el código de respuesta debe ser {int}")
    public void elCódigoDeRespuestaDebeSer(int code) {
        actor.should(
                GivenWhenThen.seeThat("El código de respuesta es: ", StatusCode.is(), equalTo(code))
        );
    }

    @And("validamos que {string} sea igual a {string}")
    public void validamosQueSeaIgualA(String path, String value) {
        actor.should(
                GivenWhenThen.seeThat("El valor del campo es: ", ResponseField.from(path), equalTo(value))
        );
    }

    @When("crear un objeto con los siguientes datos")
    public void crearUnObjetoConLosSiguientesDatos(DataTable table) {
        Map<String, String> datos = table.asMaps(String.class, String.class).getFirst();
        actor.attemptsTo(
                CreateObject.with(ResponseDTO.createBody(datos))
        );
    }

    @When("modifico el objeto con ID {string} con los siguientes datos")
    public void modificoElObjetoConIDConLosSiguientesDatos(String id) {
        actor.attemptsTo(
                PutObject.with(id, ResponseDTO.putBody())
        );
    }

    @And("validamos que {string} no sea nula")
    public void validamosQueNoSeaNula(String path) {
        actor.should(
                GivenWhenThen.seeThat("El valor del campo es: ", ResponseField.from(path), notNullValue())
        );
    }

    @When("modifico parcialmente el objeto con ID {string} con los siguientes datos")
    public void modificoParcialmenteElObjetoConIDConLosSiguientesDatos(String id) {
        actor.attemptsTo(
                PatchObject.with(id, ResponseDTO.partialBody())
        );
    }

    @When("elimino el objeto con ID {string}")
    public void eliminoElObjetoConID(String id) {
        actor.attemptsTo(
                DeleteObject.withId(id)
        );
    }

    @And("validamos que {string} contenga el siguiente texto {string}")
    public void validamosQueContengaElSiguienteTexto(String path, String value) {
        actor.should(
                GivenWhenThen.seeThat("El valor del campo es: ", ResponseField.from(path), containsString(value))
        );
    }
}
