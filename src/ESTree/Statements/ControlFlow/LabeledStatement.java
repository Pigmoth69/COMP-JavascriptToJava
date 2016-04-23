package ESTree.Statements.ControlFlow;

import ESTree.Identifier.Identifier;
import ESTree.Statements.Statement;

/**
 * Created by danny on 23/04/2016.
 */
public class LabeledStatement implements Statement{
    private String type = "LabeledStatement";
    private Identifier label;
    private Statement body;

    public LabeledStatement(Identifier label, Statement body){
        this.label=label;
        this.body = body;
    }
}
