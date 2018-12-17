package personal.davide.domain;

import com.google.gson.Gson;
import java.util.HashMap;

public class JSon {

    public String getJSonFromMap(HashMap<String, String> hashMap) {
        Gson gson = new Gson();
        String json = gson.toJson(hashMap);
        return json;
    }

    public HashMap<String, String> getMapFromJson(String json) {
        Gson gson = new Gson();
        gson.toJson(json);
        return gson.fromJson(json, HashMap.class);
    }
}
