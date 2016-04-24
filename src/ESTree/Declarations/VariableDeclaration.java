package ESTree.Declarations;

import java.util.ArrayList;

/**
 * Created by danny on 24/04/2016.
 */
public class VariableDeclaration extends Declaration {
    private String type = "VariableDeclaration";
    private ArrayList<VariableDeclarator> declarations;
    private String kind = "var";

    public VariableDeclaration(ArrayList<VariableDeclarator> declarations) {
        this.declarations = declarations;
    }
}
