package ESTree.Statements.Loops;

import ESTree.Statements.Statement;

import java.beans.Expression;

/**
 * Created by danny on 23/04/2016.
 */
public class ForInStatement implements Statement{
    private String type = "ForInStatement";
    private Object left; //VariableDeclaration |  Pattern;
    private Expression right;
    private Statement body;

    public ForInStatement(Object o, Expression right, Statement body){
        if(o instanceof VariableDeclaration){
            left = (VariableDeclaration)o;
        }else if(o instanceof  Pattern){
            left = (Pattern)o
        }else
            left = null;
        this.right=right;
        this.body=body;

    }
}
