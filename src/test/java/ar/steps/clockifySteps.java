package ar.steps;

import api.model.addprojects.AddProjectModel;
import api.model.allprojects.getAllprojectsModel;
import api.model.clients.ClientModel;
import api.model.workspace.GetAllWorkspacesModel;
import com.crowdar.api.rest.APIManager;
import com.crowdar.core.PageSteps;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import validator.CommonValidator;
import validator.workspaceValidator;

import static services.BaseService.*;

public class clockifySteps extends PageSteps {
    @Given("^tengo una apiKey correcta (.*)$")
    public void setApiKey(String apiKey) {
        API_KEY.set(apiKey);
    }


    @Then("^validar que el status code sea (.*)$")
    public void validarQueElStatusCodeSea(String expected) {
        CommonValidator.validateStatusCode(expected);
    }

    @And("valido que el campo id no sea nulo")
    public void validoQueElCampoIdNoSeaNulo() {
        workspaceValidator.validateIdNoNull();
    }

    @And("obtengo un id de workspace correcto")
    public void obtengoUnIdDeWorkspaceCorrecto() {
        GetAllWorkspacesModel[] response = (GetAllWorkspacesModel[]) APIManager.getLastResponse().getResponse();
        WORKSPACE_ID.set(response[0].id);
    }


    @And("obtengo un id de projects correcto")
    public void obtengoUnIdDeProjectsCorrecto() {
        System.out.println(" "+APIManager.getLastResponse().getResponse());
        AddProjectModel response = (AddProjectModel) APIManager.getLastResponse().getResponse();
        PROJECT_ID.set(response.getId());
    }


    @And("obtengo el id del cliente")
    public void obtengoElIdDelCliente() {
        ClientModel response = (ClientModel) APIManager.getLastResponse().getResponse();
        ID_CLIENTE.set(response.getId());
    }
}
