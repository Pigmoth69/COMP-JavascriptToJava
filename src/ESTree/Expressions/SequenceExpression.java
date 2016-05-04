package ESTree.Expressions;

import java.util.ArrayList;

/**
 * Created by danny on 24/04/2016.
 */
public class SequenceExpression extends Expression {
    private String type = "SequenceExpression";
    private ArrayList<Expression> expressions;

    public SequenceExpression(ArrayList<Expression> expressions){
        super("SequenceExpression");
        this.expressions=expressions;
    }
}
