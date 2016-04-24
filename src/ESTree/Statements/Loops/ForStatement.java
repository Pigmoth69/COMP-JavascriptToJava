package ESTree.Statements.Loops;

import ESTree.Declarations.VariableDeclaration;
import ESTree.Expressions.Expression;
import ESTree.Statements.Statement;

/**
 * Created by danny on 23/04/2016.
 */
public class ForStatement extends Statement {
    private String type = "ForStatement";
    private Object init; //init: VariableDeclaration | Expression | null;
    private Expression test;
    private Expression update;
    private Statement body;

    public ForStatement(Object o, Expression test,Expression update, Statement body){
        if(o instanceof VariableDeclaration){
            init = (VariableDeclaration)o;
        }else if(o instanceof  Expression){
            init = (Expression)o;
        }else
            init = null;
    }

}
