package ESTree.Literal;

/**
 * Created by danny on 23/04/2016.
 */
public class RegExpLiteral implements Literal{
    private String pattern;
    private String flags;

    public RegExpLiteral(String pattern,String flags){
        this.pattern=pattern;
        this.flags=flags;
    }
}
