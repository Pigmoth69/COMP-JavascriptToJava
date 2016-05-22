package Parser;

import com.google.common.base.Charsets;
import com.google.common.io.Files;
import org.apache.commons.lang3.StringEscapeUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Parser {

    private String       code;
    private ScriptEngine engine;
    private JSONObject   codeObj;
    private JSONArray    codeArray;

    public Parser(String filename) throws ScriptException, JSONException {

        loadFile(filename);
        loadEsprima();
        parseFile();

    }

    public JSONObject getCodeObj() {
        return codeObj;
    }

    private boolean loadEsprima() {

        engine = new ScriptEngineManager().getEngineByName("nashorn");

        System.out.println("Opening Esprima.js...");

        try {

            engine.eval(new FileReader("Libs/Esprima/esprima.js"));

        } catch (ScriptException | FileNotFoundException e) {

            e.printStackTrace();
            return false;

        }

        System.out.println("Esprima.js loaded!");

        return true;

    }

    private boolean loadFile(String filename) {

        System.out.println("Starting load file...");

        try {

            code = Files.toString(new File("Files/" + filename), Charsets.UTF_8);

        } catch (FileNotFoundException e) {

            System.err.println("File not found!");
            return false;

        } catch (IOException e) {

            e.printStackTrace();
            return false;

        }

        System.out.println("File completely loaded!");

        return true;

    }

    private boolean parseFile() {

//        String parseString = new String("function getCode(){var syntax = engine.parse('"+code+"'); return JSON.stringify(syntax);}");
//
//        try {
//
//            engine.eval(parseString);
//
//        } catch (ScriptException e) {
//
//            e.printStackTrace();
//            return false;
//
//        }

        try {

            String jsonString = "JSON.stringify(esprima.parse('" + StringEscapeUtils.escapeEcmaScript(code) + "'));";
            code = String.valueOf(engine.eval(jsonString));
            System.out.println(new JSONObject(code).toString(4));

            codeObj = new JSONObject(code);

        } catch (JSONException | ScriptException e) {

            e.printStackTrace();
            return false;

        }

        return true;

    }

}
