package ESTree.Expressions.BinaryOperations;

import ESTree.Expressions.Expression;
import ESTree.Patterns.Pattern;

/**
 * Created by danny on 24/04/2016.
 */
public class MemberExpression implements Expression,Pattern {
    private String type = "MemberExpression";
    private Expression object;
    private Expression property;
    private boolean computed;

    public MemberExpression(Expression object, Expression property,boolean computed){
        this.object=object;
        this.property=property;
        this.computed=computed;
    }
}
