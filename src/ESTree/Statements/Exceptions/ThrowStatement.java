package ESTree.Statements.Exceptions;

import ESTree.Statements.Statement;

/**
 * Created by danny on 23/04/2016.
 */
public class ThrowStatement implements Statement {
    private String type ="ThrowStatement";
    private Expression argument;

    public ThrowStatement(Expression argument){
        this.argument=argument;
    }
}
