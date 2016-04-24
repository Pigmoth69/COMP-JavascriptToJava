package ESTree.Statements.ControlFlow;

import ESTree.Expressions.Expression;
import ESTree.Statements.Statement;

/**
 * Created by danny on 23/04/2016.
 */
public class ReturnStatement extends Statement {
    private String type = "ReturnStatement";
    private Expression argument;

    public ReturnStatement(Expression argument){
        this.argument=argument;
    }
}
