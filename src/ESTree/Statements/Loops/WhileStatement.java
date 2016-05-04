package ESTree.Statements.Loops;

import ESTree.Expressions.Expression;
import ESTree.Statements.Statement;

/**
 * Created by danny on 23/04/2016.
 */
public class WhileStatement extends Statement {
    private String type ="WhileStatement";
    private Expression test;
    private Statement body;

    public WhileStatement(Expression test,Statement body){
        super("WhileStatement");
        this.test=test;
        this.body=body;
    }
}
