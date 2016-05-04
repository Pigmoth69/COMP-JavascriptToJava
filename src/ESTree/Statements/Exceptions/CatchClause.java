package ESTree.Statements.Exceptions;

import ESTree.NodeObjects.Node;
import ESTree.Statements.BlockStatement;

import java.util.regex.Pattern;

/**
 * Created by danny on 23/04/2016.
 */
public class CatchClause extends Node {
    private String type = "CatchClause";
    private Pattern param;
    private BlockStatement body;

    public CatchClause(Pattern param, BlockStatement body){
        super("CatchClause");
        this.param=param;
        this.body=body;
    }
}
