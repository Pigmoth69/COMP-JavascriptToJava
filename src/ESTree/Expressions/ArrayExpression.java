package ESTree.Expressions;

import java.util.ArrayList;

/**
 * Created by danny on 24/04/2016.
 */
public class ArrayExpression extends Expression {
    private String type = "ArrayExpression";
    private ArrayList<Expression> elements;

    public ArrayExpression(ArrayList<Expression> elements){
        super("ArrayExpression");
        this.elements=elements;
    }
}
