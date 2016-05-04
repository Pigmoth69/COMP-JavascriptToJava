package ESTree.Programs;

import ESTree.NodeObjects.Node;
import ESTree.Statements.Statement;

import java.util.ArrayList;

/**
 * Created by danny on 23/04/2016.
 */
public class Program extends Node {
    private String type = "Program";
    private ArrayList<Statement> statements;

    public Program(ArrayList<Statement> statements){
        super("Program");
        this.statements=statements;
    }
}
