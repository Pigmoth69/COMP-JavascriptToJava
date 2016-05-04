package ESTree.Statements.Exceptions;

import ESTree.Statements.BlockStatement;
import ESTree.Statements.Statement;

/**
 * Created by danny on 23/04/2016.
 */
public class TryStatement extends Statement {
    private String type = "TryStatement";
    private BlockStatement block;
    private CatchClause handler;
    private BlockStatement finalizer;

    public TryStatement(BlockStatement block, CatchClause handler,BlockStatement finalizer){
        super("TryStatement");
        this.block=block;
        this.handler=handler;
        this.finalizer= finalizer;
    }
}
