package Converter;

import ESTree.Declarations.VariableDeclaration;
import ESTree.Declarations.VariableDeclarator;
import ESTree.Programs.Program;
import ESTree.Statements.Statement;
import org.graphstream.graph.Graph;
import org.graphstream.graph.implementations.SingleGraph;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by danny on 05/05/2016.
 */
public class ClassBuilder {

    private Program program;
    private JSONObject jsonObject;
    private HashMap<String,String> variables;
    private ArrayList<String> functions;


    public ClassBuilder(JSONObject jsonObject){
        program = new Program(null);
        this.jsonObject=jsonObject;
    }

    public void build() throws JSONException {
        getProgramSentences();



        /*mudar o null do program. Fazer um setBody()

        System.out.println("Code: ");
        System.out.println(jsonObject);
        System.out.println("Code type: ");
        System.out.println(jsonObject.getString("type"));
        System.out.println(jsonObject.getJSONArray("body"));
        System.out.println(jsonObject.getJSONArray("body").length()); //number of sentences
        buildGraph(jsonObject).display();*/
    }

    private void getProgramSentences() throws JSONException {
        JSONArray programBody = jsonObject.getJSONArray("body");
        ArrayList<Statement> statements = new ArrayList<Statement>();
        for(int i = 0; i < programBody.length();i++){
            System.out.println("Sentence "+i+": ");
            statements.add(getSentence((JSONObject) programBody.get(i)));
        }
        program.setBody(statements);
    }

    /*Nesta função vamos buscar cada uma das sentences que constituem o programa para depois o podermos montar*/
    private Statement getSentence(JSONObject o) throws JSONException {
        String type = o.getString("type");

        switch(type){
            case "VariableDeclaration":
                Statement variableDeclaration;
                variableDeclaration = getVariableDeclaration(o);
                return variableDeclaration;
            case "FunctionDeclaration":
                break;
            default:
                System.err.println("ERROR ON Statement PARSING!!");
        }
        System.out.println(o.getString("type"));
/*TENHO DE MUDAR ESTE RETURN!!*/return null;
    }

    /*Esta função vai buscar as declarations de cada VariableDeclaration*/
    private Statement getVariableDeclaration(JSONObject o) throws JSONException {
        ArrayList<VariableDeclarator> declarations = new ArrayList<VariableDeclarator>();
        JSONArray jsonDeclaration = o.getJSONArray("declarations");
        for(int i = 0; i < jsonDeclaration.length();i++){
            VariableDeclarator temp = getVariableDeclarator((JSONObject)jsonDeclaration.get(i));
            declarations.add(temp);
        }

        return new VariableDeclaration(declarations);
    }

    private VariableDeclarator getVariableDeclarator(JSONObject jsonObject) throws JSONException {
        System.out.println("VariableDeclaratorParse:");
        System.out.println(jsonObject.get("type"));
        System.out.println(jsonObject.get("id"));
        if(jsonObject.isNull("init"))
         System.out.println("é null");
        else
        System.out.println("nao é null");
        return null;
    }


































    public static Graph buildGraph(JSONObject json) {

        Graph graph = new SingleGraph("");

        recursive(graph, json);

        return graph;

    }


    public static void recursive(Graph graph, JSONObject json) {

        String type;

        try {
            type = json.getString("type");
        } catch (JSONException e) {
            e.printStackTrace();
            return;
        }

        graph.addNode(type).setAttribute("ui.label", type);

        switch (type) {

            case "Program":

                try {
                    recursive(graph, json.getJSONArray("body").getJSONObject(0));
                } catch (JSONException e) {
                    e.printStackTrace();
                    return;
                }

                break;

            case "VariableDeclaration":

                try {
                    recursive(graph, json.getJSONArray("declarations").getJSONObject(0));
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                break;

            case "VariableDeclarator":

                try {
                    recursive(graph, json.getJSONObject("id"));
                    recursive(graph, json.getJSONObject("init"));
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                break;

            case "Identifier":

                try {
                    String name = json.getString("name");
                    graph.addNode(name).setAttribute("ui.label", name);
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                break;

            case "Literal":

                try {
                    String value = String.valueOf(json.getInt("value"));
                    graph.addNode(value).setAttribute("ui.label", value);
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                break;

            default: break;

        }

    }
}

