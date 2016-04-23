package ESTree.Statements.ControlFlow;

import ESTree.Statements.Statement;

/**
 * Created by danny on 23/04/2016.
 */
public class ReturnStatement implements Statement{
    private String type = "ReturnStatement";
    private Expression argument;

    public ReturnStatement(Expression argument){
        this.argument=argument;
    }
}
