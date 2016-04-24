package ESTree.Expressions.UnaryOperations;

/**
 * Created by danny on 24/04/2016.
 */
public class UnaryOperator {
    private String operator;

    public UnaryOperator(String operator){
        switch (operator){
            case "-":
                this.operator=operator;
                break;
            case "+":
                this.operator=operator;
                break;
            case "!":
                this.operator=operator;
                break;
            case "~":
                this.operator=operator;
                break;
            case "typeof":
                this.operator=operator;
                break;
            case "void":
                this.operator=operator;
                break;
            case "delete":
                this.operator=operator;
                break;
            default:
                System.err.println("invalid operator");
        }
    }
}
