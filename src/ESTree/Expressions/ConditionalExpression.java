package ESTree.Expressions;

/**
 * Created by danny on 24/04/2016.
 */
public class ConditionalExpression extends Expression {
    private String type = "ConditionalExpression";
    private Expression test;
    private Expression alternate;
    private  Expression consequent;

    public ConditionalExpression(Expression test,Expression alternate, Expression consequent){
        super("ConditionalExpression");
        this.test=test;
        this.alternate=alternate;
        this.consequent=consequent;
    }
}
