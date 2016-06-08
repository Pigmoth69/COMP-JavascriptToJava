package Parser;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.HashMap;

public class TypeParserFunction {

    private String name;
    private String returnType;
    private HashMap<String, String> args;
    private HashMap<String, String> localVariables;

    public TypeParserFunction(JSONObject obj) {

        args = new HashMap<>();
        localVariables = new HashMap<>();

        name = (String)obj.get("name");
        returnType = (String)obj.get("return_type");

        JSONArray jsonArgs = (JSONArray)obj.get("args");
        JSONArray jsonLocalVariables = (JSONArray)obj.get("local_variables");

        for (Object arg : jsonArgs) {
            String name = (String) ((JSONObject)arg).get("name");
            String type = (String) ((JSONObject)arg).get("type");
            args.put(name, type);
        }

        for (Object arg : jsonLocalVariables) {
            String name = (String) ((JSONObject)arg).get("name");
            String type = (String) ((JSONObject)arg).get("type");
            localVariables.put(name, type);
        }

    }

    public String getReturnType() {
        return returnType;
    }

    public String getArgumentType(String argumentName) {
        return args.get(argumentName);
    }

    public String getLocalVariableType(String localVariableName) {
        return localVariables.get(localVariableName);
    }

}
