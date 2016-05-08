package ESTree.Programs;

import ESTree.NodeObjects.Node;
import ESTree.Statements.Statement;

import java.util.ArrayList;

/**
 * Created by danny on 23/04/2016.
 */
public class Program extends Node {
    private String type = "Program";
    private ArrayList<Statement> body;

    public Program(ArrayList<Statement> body){
        super("Program");
        this.body=body;
    }

    public ArrayList<Statement> getBody() {
        return body;
    }

    public void setBody(ArrayList<Statement> body) {
        this.body = body;
    }
}
