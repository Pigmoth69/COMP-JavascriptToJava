package ESTree.Declarations;

import ESTree.Expressions.Expression;
import ESTree.NodeObjects.Node;
import ESTree.Patterns.Pattern;

/**
 * Created by danny on 24/04/2016.
 */
public class VariableDeclarator extends Node {
    private String type = "VariableDeclarator";
    private Pattern id;
    private Expression init;

    public VariableDeclarator(Pattern id,Expression init){
        super(null,null);
        this.id=id;
        this.init=init;
    }
}
