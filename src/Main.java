import jdk.nashorn.internal.parser.JSONParser;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import java.io.File;
import java.io.FileReader;


public class Main {

    public static void main(String[] args) throws Throwable {
        ScriptEngineManager engineManager = new ScriptEngineManager();
        ScriptEngine engine = engineManager.getEngineByName("nashorn");
        System.out.println("Opening File...");
        File file = new File("Libs/Esprima.js");
        engine.eval(new FileReader(file));
        System.out.println("File loaded!");
        engine.eval("function getCode(){var syntax = esprima.parse('var answer = 42'); return JSON.stringify(syntax);}");
        System.out.println(engine.eval("getCode();"));



    }

}