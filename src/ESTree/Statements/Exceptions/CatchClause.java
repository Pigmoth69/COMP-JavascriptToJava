package ESTree.Statements.Exceptions;

import ESTree.NodeObjects.Node;
import ESTree.Statements.BlockStatement;

/**
 * Created by danny on 23/04/2016.
 */
public class CatchClause implements Node {
    private String type = "CatchClause";
    private Pattern param;
    private BlockStatement body;

    public CatchClause(Pattern param, BlockStatement body){
        this.param=param;
        this.body=body;
    }
}
