package ESTree.Declarations;

import ESTree.Expressions.Expression;
import ESTree.Identifier.Identifier;
import ESTree.Literal.Literal;
import ESTree.NodeObjects.Node;

/**
 * Created by danny on 24/04/2016.
 */
public class VariableDeclarator extends Node {
    private String type = "VariableDeclarator";
    private Identifier identifier;
    private Literal literal;
    private Expression init;

    public VariableDeclarator(Identifier identifier,Literal literal, Expression init){
        super("VariableDeclarator");
        this.identifier=identifier;
        this.literal=literal;
        this.init=init;
    }
}
