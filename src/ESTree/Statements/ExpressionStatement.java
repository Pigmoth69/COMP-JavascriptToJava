package ESTree.Statements;

import ESTree.Expressions.Expression;

/**
 * Created by danny on 23/04/2016.
 */
public class ExpressionStatement extends Statement {
    private String type = "ExpressionStatement";
    private Expression expression;

    public ExpressionStatement(Expression expression){
        super("ExpressionStatement");
        this.expression=expression;
    }
}
