package ESTree.Statements.Choice;

import ESTree.Expressions.Expression;
import ESTree.Statements.Statement;

/**
 * Created by danny on 23/04/2016.
 */
public class IfStatement extends Statement {
    private String type ="IfStatement";
    private Expression test;
    private Statement consequent;
    private Statement alternate;

    public IfStatement(Expression test,Statement consequent,Statement alternate){
        super("IfStatement");
        this.test = test;
        this.consequent=consequent;
        this.alternate=alternate;
    }
}
