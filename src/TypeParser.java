import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class TypeParser {

    private static HashMap<String, String> globalVariables;
    private static HashMap<String, TypeParserFunction> functions;

    public static void init() {

        JSONParser parser = new JSONParser();
        globalVariables = new HashMap<>();
        functions = new HashMap<>();

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
                TypeParserFunction tpFunction = new TypeParserFunction((JSONObject) function);
                functions.put(name, tpFunction);
            }

        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }

    }

    public static String getGlobalVariableType(String variableName) {
        return globalVariables.get(variableName);
    }

    public static String getFunctionReturnType(String functionName) {
        return functions.get(functionName).getReturnType();
    }

    public static String getFunctionArgumentType(String functionName, String argumentName) {
        return "";
    }

}