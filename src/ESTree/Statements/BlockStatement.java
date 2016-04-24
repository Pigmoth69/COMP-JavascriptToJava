package ESTree.Statements;

import java.util.ArrayList;

/**
 * Created by danny on 23/04/2016.
 */
public class BlockStatement extends Statement {
    private String type = "BlockStatement";
    private ArrayList<Statement> body;

    public BlockStatement(ArrayList<Statement> body){
        this.body = body;
    }
}
