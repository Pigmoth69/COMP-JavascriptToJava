import Converter.ClassBuilder;
import Parser.Parser;

public class Main {

    public static void main(String[] args) throws Throwable {

        Parser parser = new Parser("teste.js");
        System.out.println("Code:");
        System.out.println(parser.getCodeObj());
        ClassBuilder classBuilder = new ClassBuilder(parser.getCodeObj());
        classBuilder.build();


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

       /* Graph.Graph graph = new SingleGraph("Tutorial 1");

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
}