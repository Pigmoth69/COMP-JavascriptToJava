package ESTree.Expressions;

import java.util.ArrayList;

/**
 * Created by danny on 24/04/2016.
 */
public class ObjectExpression extends Expression {
    private String type = "ObjectExpression";
    private ArrayList<Property> properties;

    public ObjectExpression(ArrayList<Property> properties){
        super("ObjectExpression");
        this.properties=properties;
    }
}
