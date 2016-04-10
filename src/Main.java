import Parser.Parser;

public class Main {

    public static void main(String[] args) throws Throwable {

        Parser parser = new Parser("teste.js");
        System.out.println(parser.getCode());


        /*ScriptEngineManager engineManager = new ScriptEngineManager();
        ScriptEngine engine = engineManager.getEngineByName("nashorn");
        System.out.println("Opening File...");
        File file = new File("Libs/Esprima.js");
        engine.eval(new FileReader(file));
        System.out.println("File loaded!");
        engine.eval("function getCode(){var syntax = esprima.parse('var answer = 42'); return JSON.stringify(syntax);}");
        System.out.println(engine.eval("getCode();"));*/

        /*Graph graph = new SingleGraph("Tutorial 1");

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