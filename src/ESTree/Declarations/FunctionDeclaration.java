package ESTree.Declarations;

import ESTree.Functions.Function;
import ESTree.Identifier.Identifier;

/**
 * Created by danny on 23/04/2016.
 */
public class FunctionDeclaration extends Function,Declaration {
    private String type = "FunctionDeclaration";
    private Identifier id;

    public FunctionDeclaration(Identifier id){
        super();
        this.id=id;
    }
}
