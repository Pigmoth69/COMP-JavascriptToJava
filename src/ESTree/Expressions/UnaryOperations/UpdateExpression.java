package ESTree.Expressions.UnaryOperations;

import ESTree.Expressions.Expression;

/**
 * Created by danny on 24/04/2016.
 */
public class UpdateExpression extends Expression {
    private String type = "UpdateExpression";
    private UpdateOperator operator;
    private Expression argument;
    private boolean prefix;

    public UpdateExpression(UpdateOperator operator, Expression argument,boolean prefix){
        this.operator=operator;
        this.argument=argument;
        this.prefix=prefix;
    }
}
