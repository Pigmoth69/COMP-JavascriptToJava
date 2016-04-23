package ESTree.Declarations;

import ESTree.Identifier.Identifier;

/**
 * Created by danny on 23/04/2016.
 */
public class FunctionDeclaration implements Function,Declaration {
    private String type = "FunctionDeclaration";
    private Identifier id;

    public FunctionDeclaration(Identifier id){
        this.id=id;
    }
}
