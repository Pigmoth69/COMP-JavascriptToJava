package ESTree.Expressions;

import java.util.ArrayList;

/**
 * Created by danny on 24/04/2016.
 */
public class CallExpression extends Expression {
    private String type = "CallExpression";
    private Expression callee;
    private ArrayList<Expression> arguments;

    public CallExpression(Expression callee, ArrayList<Expression> arguments){
        super("CallExpression");
        this.callee=callee;
        this.arguments=arguments;
    }
}
