package Parser;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

/**
 * Created by danny on 09/04/2016.
 */
public class Parser {
    private File file;
    private String code = new String();
    private ScriptEngineManager engineManager;
    private ScriptEngine engine;
    private JSONObject obj;
    private JSONArray codeArray;

    public Parser(String filename) throws ScriptException, FileNotFoundException, JSONException {
        file = new File("Files/"+filename);
        if(!file.exists()) {
            System.err.println("File does not exists! It should be a JavaScript file contained in the folder Files!!");
            return;
        }
        loadLibs();
        loadFile();
        parseFile();
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public JSONObject getObj() {
        return obj;
    }

    public void setObj(JSONObject obj) {
        this.obj = obj;
    }

    public JSONArray getCodeArray() {
        return codeArray;
    }

    public void setCodeArray(JSONArray codeArray) {
        this.codeArray = codeArray;
    }

    public void loadLibs() throws FileNotFoundException, ScriptException {
        engineManager = new ScriptEngineManager();
        engine = engineManager.getEngineByName("nashorn");
        System.out.println("Opening Esprima.js...");
        File lib = new File("Libs/Esprima/esprima.js");
        if(!lib.exists())
            System.err.println("Esprima lib does not exists!");
        else
            System.out.println("Esprima lib exists!");
        engine.eval(new FileReader(lib));
        System.out.println("Esprima.js loaded!");
    }

    public void loadFile() throws FileNotFoundException {
        System.out.println("Starting load file...");
        Scanner sc = new Scanner(file);
        while (sc.hasNextLine())
            code+= sc.nextLine();
        sc.close();
        System.out.println("File completely loaded!");
    }



    public void parseFile() throws ScriptException, JSONException {
        System.out.println("Parsing file... Please wait.");
       String parseString = new String("function getCode(){var syntax = esprima.parse('"+code+"'); return JSON.stringify(syntax);}");
        engine.eval(parseString);
        code = (String)engine.eval("getCode();");
        obj = new JSONObject(code);
        //falta o array
    }

}
