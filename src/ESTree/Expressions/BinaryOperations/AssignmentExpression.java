package ESTree.Expressions.BinaryOperations;

import ESTree.Expressions.Expression;
import ESTree.Patterns.Pattern;

/**
 * Created by danny on 24/04/2016.
 */
public class AssignmentExpression extends Expression {
    private String type = "AssignmentExpression";
    private AssignmentOperator operator;
    private Object left;
    private Expression right;

    public AssignmentExpression(AssignmentOperator operator, Object left,Expression right){
        this.operator=operator;
        if(left instanceof Pattern){
            this.left=(Pattern)left;
        }else if(left instanceof  Expression){
            this.left=(Expression)left;
        }else
            System.err.println("invalid operator of AssignmentOperator operator");
        this.right=right;
    }
}
