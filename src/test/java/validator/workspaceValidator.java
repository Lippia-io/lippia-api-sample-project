package validator;

import api.model.workspace.GetAllWorkspacesModel;
import com.crowdar.api.rest.APIManager;
import org.testng.Assert;

public class workspaceValidator {
    public static void validate(){
        GetAllWorkspacesModel[] response = (GetAllWorkspacesModel[]) APIManager.getLastResponse().getResponse();

    }


    public static void validateIdNoNull(){
        GetAllWorkspacesModel[] response = (GetAllWorkspacesModel[]) APIManager.getLastResponse().getResponse();
        Assert.assertNotNull(response[0].id, "El campo ID es nulo");
    }
}
