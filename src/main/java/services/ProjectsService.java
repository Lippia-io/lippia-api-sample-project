package services;

import api.model.addprojects.AddProjectModel;
import api.model.addworkspace.getAddworkspaceModel;
import api.model.allprojects.getAllprojectsModel;
import api.model.deleteprojects.DeleteprojectsModel;
import com.crowdar.api.rest.Response;
import org.springframework.web.client.RestClientException;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

public class ProjectsService extends BaseService {

    public static Response get(String jsonName) {
        try {
            return get(jsonName, AddProjectModel[].class, setParams());
        } catch (RestClientException e) {
            return get(jsonName, AddProjectModel.class, setParams());
        } catch (Exception e) {
            return null;
        }

    }

    public static Response post(String jsonRequest) {
        return post(jsonRequest, AddProjectModel.class, setParams());
    }

    public static Response put(String jsonRequest) {
        return put(jsonRequest, DeleteprojectsModel.class, setParams());
    }

    public static Response delete(String jsonRequest) {
        return delete(jsonRequest, DeleteprojectsModel.class, setParams());
    }


    private static Map<String, String> setParams() {
        Map<String, String> params = new HashMap<String, String>();
        params.put("apikey", API_KEY.get());

        if (WORKSPACE_ID.get() != null) {
            params.put("workspaceId", WORKSPACE_ID.get());
        }

        if (PROJECT_ID.get() != null) {
            params.put("projectId", PROJECT_ID.get());
        }

        String uniqueProjectName = "TestProject_" + System.currentTimeMillis();
        PROJECT_NAME.set(uniqueProjectName);
        params.put("projectName", uniqueProjectName);

        return params;
    }


}
