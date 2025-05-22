package services;

import api.model.workspace.GetAllWorkspacesModel;
import com.crowdar.api.rest.Response;

import java.util.HashMap;
import java.util.Map;

public class WorkspaceService extends BaseService {
    public static Response get(String jsonName) {
        return get(jsonName, GetAllWorkspacesModel[].class, setParams());
    }

    private static Map<String, String> setParams() {
        Map<String, String> params = new HashMap<String, String>();
        params.put("apikey", API_KEY.get());
        return params;
    }
}
