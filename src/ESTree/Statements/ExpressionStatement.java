package ESTree.Statements;

/**
 * Created by danny on 23/04/2016.
 */
public class ExpressionStatement implements Statement{
    private String type = "ExpressionStatement";
    private Expression expression;

    public ExpressionStatement(Expression expression){
        this.expression=expression;
    }
}
