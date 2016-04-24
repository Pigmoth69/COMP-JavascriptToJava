package ESTree.Expressions.UnaryOperations;

/**
 * Created by danny on 24/04/2016.
 */
public class UpdateOperator{
    private String operator;

    public UpdateOperator(String operator){
        switch(operator){
            case "++":
                this.operator=operator;
                break;
            case "--":
                this.operator=operator;
                break;
            default:
                System.err.println("Error on update operator");
        }
    }
}
