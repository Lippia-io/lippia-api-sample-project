package services;

import api.model.clients.ClientModel;
import com.crowdar.api.rest.Response;

import java.util.HashMap;
import java.util.Map;

public class ClientsService extends BaseService {
    public static Response post(String jsonName) {
        return post(jsonName, ClientModel.class, setParams());
    }

    public static Response get(String jsonName) {
        return get(jsonName, ClientModel.class, setParams());
    }

    private static Map<String, String> setParams() {
        Map<String, String> params = new HashMap<String, String>();
        params.put("apikey", API_KEY.get());
        params.put("workspaceId", WORKSPACE_ID.get());
        String ADDRESS = "Ground Floor, ABC Bldg., Palo Alto, California, USA 94020";
        String NAME = "Angi_" + System.currentTimeMillis();
        String EMAIL = NAME + "@gmail.com";
        String NOTE = "This is a sample note for the client.";
        params.put("address", ADDRESS);
        params.put("email", EMAIL);
        params.put("name", NAME);
        params.put("note", NOTE);

        if (ID_CLIENTE.get() != null) {
            params.put("idCliente", ID_CLIENTE.get());
        } else {
            params.put("idCliente", "");
        }

        return params;
    }
}
