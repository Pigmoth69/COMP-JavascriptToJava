package ESTree.Statements.Loops;

import ESTree.Statements.Statement;

/**
 * Created by danny on 23/04/2016.
 */
public class DoWhileStatement implements Statement {
    private String type ="DoWhileStatement";
    private Statement body;
    private Expression test;

    public DoWhileStatement(Statement body,Expression test){
        this.body=body;
        this.test=test;
    }
}
