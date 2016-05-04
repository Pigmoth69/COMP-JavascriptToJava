package ESTree.Declarations;

import ESTree.Identifier.Identifier;
import ESTree.Statements.BlockStatement;

import java.util.ArrayList;
import java.util.regex.Pattern;

/**
 * Created by danny on 23/04/2016.
 */
public class FunctionDeclaration extends Declaration {
    private String type = "FunctionDeclaration";
    private Identifier id;
    private ArrayList<Pattern> params;
    private BlockStatement body;

    public FunctionDeclaration(Identifier id,ArrayList<Pattern> params,BlockStatement body){
        super("FunctionDeclaration");
        this.id = id;
        this.params=params;
        this.body = body;
    }

}
