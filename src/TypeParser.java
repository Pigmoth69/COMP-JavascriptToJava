import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class TypeParser {

    private static HashMap<String, String> globalVariables;

    public static void init() {

        JSONParser parser = new JSONParser();
        globalVariables = new HashMap<String, String>();

        try {

            JSONObject jsonObject = (JSONObject) parser.parse(new FileReader("Files/types.json"));

            JSONArray jsonGlobalVariables = (JSONArray)jsonObject.get("global_variables");
            JSONArray jsonFunctions = (JSONArray)jsonObject.get("functions");

            for (Object var : jsonGlobalVariables) {
                String name = (String) ((JSONObject)var).get("name");
                String type = (String) ((JSONObject)var).get("type");
                globalVariables.put(name, type);
            }

            for (Object function : jsonFunctions) {

                String name = (String) ((JSONObject)function).get("name");

            }

        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }

    }

    public static String getGlobalVariableType(String variableName) {
        return globalVariables.get(variableName);
    }

}