package ESTree.Identifier;

/**
 * Created by danny on 21/04/2016.
 */
public class Identifier implements Expression, Pattern{
    private String type = "Identifier";
    private String name;

    public Identifier(String name){
        this.name = name;
    }
}