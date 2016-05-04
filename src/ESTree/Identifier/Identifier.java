package ESTree.Identifier;

import ESTree.Expressions.Expression;

/**
 * Created by danny on 21/04/2016.
 */
public class Identifier extends Expression{
    private String type = "Identifier";
    private String name;

    public Identifier(String name){
        super("Identifier");
        this.name = name;
    }
}