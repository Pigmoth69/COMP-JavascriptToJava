package ESTree.Statements.Choice;

import ESTree.NodeObjects.Node;
import ESTree.Statements.Statement;

import java.util.ArrayList;

/**
 * Created by danny on 23/04/2016.
 */
public class SwitchCase implements Node {
    private String type = "SwitchCase";
    private Expression test;
    private ArrayList<Statement> consequent;

    public SwitchCase(Expression test,ArrayList<Statement> consequent){
        this.test=test;
        this.consequent=consequent;
    }
}
