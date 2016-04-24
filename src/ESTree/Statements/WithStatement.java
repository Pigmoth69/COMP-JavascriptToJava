package ESTree.Statements;

import ESTree.Expressions.Expression;

/**
 * Created by danny on 23/04/2016.
 */
public class WithStatement extends Statement {
    private String type = "WithStatement";
    private Expression object;
    private Statement body;

    public WithStatement(Expression object,Statement body){
        this.object=object;
        this.body = body;
    }
}
