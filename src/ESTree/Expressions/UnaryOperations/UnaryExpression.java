package ESTree.Expressions.UnaryOperations;

import ESTree.Expressions.Expression;

import java.util.function.UnaryOperator;

/**
 * Created by danny on 24/04/2016.
 */
public class UnaryExpression extends Expression {
    private String type = "UnaryExpression";
    private UnaryOperator operator;
    private boolean prefix;
    private Expression argument;

    public UnaryExpression(UnaryOperator operator, boolean prefix, Expression argument){
        this.operator=operator;
        this.prefix=prefix;
        this.argument=argument;
    }
}
