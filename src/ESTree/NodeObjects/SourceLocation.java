package ESTree.NodeObjects;

/**
 * Created by danny on 21/04/2016.
 */
public class SourceLocation {
    private String source;
    private int startPos;
    private int endPos;

    public SourceLocation(String source,int startPos,int endPos){
        this.source=source;
        this.startPos=startPos;
        this.endPos=endPos;
    }

    public String getSource() {
        return source;
    }

    public int getStartPos() {
        return startPos;
    }

    public int getEndPos() {
        return endPos;
    }
}
