package ESTree.Statements.Choice;

import ESTree.Expressions.Expression;
import ESTree.NodeObjects.Node;
import ESTree.Statements.Statement;

import java.util.ArrayList;

/**
 * Created by danny on 23/04/2016.
 */
public class SwitchCase extends Node {
    private String type = "SwitchCase";
    private Expression test;
    private ArrayList<Statement> consequent;

    public SwitchCase(Expression test,ArrayList<Statement> consequent){
        super(null,null);
        this.test=test;
        this.consequent=consequent;
    }
}
