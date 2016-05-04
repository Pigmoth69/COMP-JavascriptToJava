package ESTree.Statements.Loops;

import ESTree.Declarations.VariableDeclaration;
import ESTree.Statements.Statement;

import java.beans.Expression;

/**
 * Created by danny on 23/04/2016.
 */
public class ForInStatement extends Statement {
    private String type = "ForInStatement";
    private Object left; //VariableDeclaration |  Pattern;
    private Expression right;
    private Statement body;

    public ForInStatement(Object o, Expression right, Statement body){
        super("ForInStatement");
        if(o instanceof VariableDeclaration){
            left = (VariableDeclaration)o;
        }else
            left = null;
        this.right=right;
        this.body=body;

    }
}
