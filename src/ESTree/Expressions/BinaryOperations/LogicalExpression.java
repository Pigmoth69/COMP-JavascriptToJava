package ESTree.Expressions.BinaryOperations;

import ESTree.Expressions.Expression;

/**
 * Created by danny on 24/04/2016.
 */
public class LogicalExpression extends Expression {
    private String type = "LogicalExpression";
    private LogicalOperator operator;
    private Expression left;
    private Expression right;

    public LogicalExpression(LogicalOperator operator, Expression left, Expression right){
        this.operator=operator;
        this.left=left;
        this.right=right;
    }
}
