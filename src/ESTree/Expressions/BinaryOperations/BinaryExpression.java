package ESTree.Expressions.BinaryOperations;

import ESTree.Expressions.Expression;

/**
 * Created by danny on 24/04/2016.
 */
public class BinaryExpression extends Expression {
    private String type = "BinaryExpression";
    private BinaryOperator operator;
    private Expression left;
    private Expression right;

    public BinaryExpression(BinaryOperator operator,Expression left, Expression right){
        super("BinaryExpression");
        this.operator=operator;
        this.left=left;
        this.right=right;
    }
}
