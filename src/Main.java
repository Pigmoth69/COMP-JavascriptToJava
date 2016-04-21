import Parser.Parser;
import org.graphstream.graph.Graph;
import org.graphstream.graph.implementations.SingleGraph;
import org.json.JSONException;
import org.json.JSONObject;

public class Main {

    public static void main(String[] args) throws Throwable {

        Parser parser = new Parser("teste.js");
        System.out.println(parser.getCode());

        JSONObject json = parser.getObj();
        buildGraph(json).display();
        /*System.out.println(parser.getObj().getJSONArray("body").length());
        System.out.println(parser.getObj().getJSONArray("body").get(0));*/
        /*String[] names = JSONObject.getNames(parser.getObj());
        System.out.println("Tamanho: "+names.length);
        JSONArray jsonArray = parser.getObj().toJSONArray(new JSONArray(names));
        System.out.println("Tamanho3: "+jsonArray.get(2).toString());
        names = JSONObject.getNames(new JSONObject(jsonArray.get(2).toString()));
        System.out.println(names);*/
        /*ScriptEngineManager engineManager = new ScriptEngineManager();
        ScriptEngine engine = engineManager.getEngineByName("nashorn");
        System.out.println("Opening File...");
        File file = new File("Libs/Esprima.js");
        engine.eval(new FileReader(file));
        System.out.println("File loaded!");
        engine.eval("function getCode(){var syntax = esprima.parse('var answer = 42'); return JSON.stringify(syntax);}");
        System.out.println(engine.eval("getCode();"));*/

       /* Graph graph = new SingleGraph("Tutorial 1");

        graph.addNode("A");

        graph.addNode("B");
        graph.addNode("C");
        graph.addEdge("AB", "A", "B");
        graph.addEdge("BC", "B", "C");
        graph.addEdge("CA", "C", "A");
        for (Node node : graph) {
            node.addAttribute("ui.label", node.getId());
        }

        graph.display();*/


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