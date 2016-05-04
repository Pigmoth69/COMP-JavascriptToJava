package ESTree.Expressions;

import ESTree.Identifier.Identifier;
import ESTree.Statements.BlockStatement;

import java.util.ArrayList;
import java.util.regex.Pattern;

/**
 * Created by danny on 24/04/2016.
 */
public class FunctionExpression extends Expression {
    private String type = "FunctionExpression";
    private Identifier id;
    private ArrayList<Pattern> params;
    private BlockStatement body;

    public FunctionExpression(Identifier id,ArrayList<Pattern> params,BlockStatement body){
        super("FunctionExpression");
        this.id = id;
        this.params=params;
        this.body = body;
    }
}
