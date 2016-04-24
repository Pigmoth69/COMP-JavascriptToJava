package ESTree.Expressions.BinaryOperations;

/**
 * Created by danny on 24/04/2016.
 */
public class LogicalOperator{
    private String operator;

    public LogicalOperator(String operator){
        switch (operator){
            case "||":
                this.operator=operator;
                break;
            case "&&":
                this.operator=operator;
                break;
            default:
                System.err.println("LogicalOperator error!");
        }
    }
}
