package ESTree.Statements.Exceptions;

import ESTree.NodeObjects.Node;
import ESTree.Patterns.Pattern;
import ESTree.Statements.BlockStatement;

/**
 * Created by danny on 23/04/2016.
 */
public class CatchClause extends Node {
    private String type = "CatchClause";
    private Pattern param;
    private BlockStatement body;

    public CatchClause(Pattern param, BlockStatement body){
        super(null,null);
        this.param=param;
        this.body=body;
    }
}
