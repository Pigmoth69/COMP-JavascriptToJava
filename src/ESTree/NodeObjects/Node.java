package ESTree.NodeObjects;

/**
 * Created by danny on 21/04/2016.
 */
public class Node {
    private String type;
    private String loc;

    public Node(String type,String loc){
        this.type = type;
        this.loc=loc;
    }

    public String getType() {
        return type;
    }

    public String getLoc() {
        return loc;
    }
}
