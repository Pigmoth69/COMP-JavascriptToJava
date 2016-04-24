package ESTree.Functions;

import ESTree.Identifier.Identifier;
import ESTree.NodeObjects.Node;
import ESTree.Patterns.Pattern;
import ESTree.Statements.BlockStatement;

import java.util.ArrayList;

/**
 * Created by danny on 23/04/2016.
 */
public class Function extends Node {
    private Identifier id;
    private ArrayList<Pattern> params;
    private BlockStatement body;
    public Function(Identifier id,ArrayList<Pattern> params,BlockStatement body){
        super(null,null);
        this.id = id;
        this.params=params;
        this.body = body;
    }
}
