package ESTree.Statements.Choice;

import ESTree.Statements.Statement;

import java.util.ArrayList;

/**
 * Created by danny on 23/04/2016.
 */
public class SwitchStatement implements Statement {
    private String type = "SwitchStatement";
    private Expression disciminent;
    private ArrayList<SwitchCase> cases;

    public SwitchStatement(Expression disciminent,ArrayList<SwitchCase> cases){
        this.disciminent=disciminent;
        this.cases = cases;
    }
}
