package ESTree.Expressions;

import ESTree.Identifier.Identifier;
import ESTree.Literal.Literal;
import ESTree.NodeObjects.Node;

/**
 * Created by danny on 24/04/2016.
 */
public class Property extends Node {
    private String type ="Property";
    private Object key; // Literal | Identifier
    private Expression value;
    private String kind;

    public Property(Object key,Expression value,String kind){
        super(null,null);
        if(key instanceof Literal){
            this.key = (Literal)key;
        }else if(key instanceof Identifier){
            this.key = (Identifier)key;
        }else{
            System.err.println("error on property");
        }

        this.value=value;
        switch(kind){
            case "init":
                this.kind=kind;
                break;
            case "get":
                this.kind=kind;
                break;
            case "set":
                this.kind=kind;
                break;
            default:
                System.err.println("error no value of property");
        }
    }
}
