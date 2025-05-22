package services;

import api.model.addworkspace.getAddworkspaceModel;
import com.crowdar.api.rest.Response;

import java.util.HashMap;
import java.util.Map;

public class AddWorkspaceService extends BaseService {

    private static Map<String, String> setParams() {
        Map<String, String> params = new HashMap<String, String>();
        params.put("apikey", API_KEY.get());
        return params;
    }

    public static Response post(String jsonName) {
        return post(jsonName, getAddworkspaceModel.class, setParams());
    }
}
