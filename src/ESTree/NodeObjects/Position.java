package ESTree.NodeObjects;

/**
 * Created by danny on 21/04/2016.
 */
public class Position {
    private int lineNumber; // >= 1
    private int columnNumber; // >= 0

    public Position(int lineNumber,int columnNumber){
        this.lineNumber=lineNumber;
        this.columnNumber=columnNumber;
    }

    public int getLineNumber() {
        return lineNumber;
    }

    public int getColumnNumber() {
        return columnNumber;
    }
}
