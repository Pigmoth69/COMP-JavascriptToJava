package AST;

import java.util.ArrayList;

/**
 * Created by danny on 06/06/2016.
 */
public class Functions {
    private String functionName;
    private ArrayList<String> parameters = new ArrayList<>();
    private String body;
    private String returnType;

    public Functions(String functionName,ArrayList<String> parameters,String body,String returnType){
        this.functionName=functionName;
        this.parameters=parameters;
        this.body=body;
        this.returnType=returnType;
    }

    public String getFunctionName() {
        return functionName;
    }

    public ArrayList<String> getParameters() {
        return parameters;
    }

    public String getBody() {
        return body;
    }

    public String getReturnType() {
        return returnType;
    }
}
