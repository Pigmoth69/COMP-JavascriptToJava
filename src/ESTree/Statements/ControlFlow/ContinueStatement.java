package ESTree.Statements.ControlFlow;

import ESTree.Identifier.Identifier;
import ESTree.Statements.Statement;

/**
 * Created by danny on 23/04/2016.
 */
public class ContinueStatement extends Statement {
    private String type = "ContinueStatement";
    private Identifier label;

    public ContinueStatement(Identifier label){
        this.label= label;
    }
}
