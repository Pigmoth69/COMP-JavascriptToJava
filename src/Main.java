import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;

public class Main {

    public static void main(String[] args) throws Throwable {
        ScriptEngineManager engineManager = new ScriptEngineManager();
        ScriptEngine engine = engineManager.getEngineByName("nashorn");
        File f = new File("Libs//teste.txt");
        if(f.exists())
            System.out.println("EXISTE!!");
        else
            System.out.println("NAO EXISTE!!");
       //engine.eval(new FileReader("//Libs//Esprima.js"));
        //engine.eval("function sum(a, b) { return a + b; }");
       // System.out.println(engine.eval("sum(1, 2);"));


    }

}

/*
engine.eval(new FileReader("src/sample1/greeter.js"));
System.out.println(invocable.invokeFunction("greet", "Julien"))
*/

