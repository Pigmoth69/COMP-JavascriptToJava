package ESTree.Expressions.BinaryOperations;

/**
 * Created by danny on 24/04/2016.
 */
public class BinaryOperator{
    private String operator;

    public BinaryOperator(String operator){
        switch(operator){
            case "==":
                this.operator=operator;
                break;
            case "!=":
                this.operator=operator;
                break;
            case "===":
                this.operator=operator;
                break;
            case "!==":
                this.operator=operator;
                break;
            case "<":
                this.operator=operator;
                break;
            case "<=":
                this.operator=operator;
                break;
            case ">":
                this.operator=operator;
                break;
            case ">=":
                this.operator=operator;
                break;
            case "<<":
                this.operator=operator;
                break;
            case ">>":
                this.operator=operator;
                break;
            case ">>>":
                this.operator=operator;
                break;
            case "+":
                this.operator=operator;
                break;
            case "-":
                this.operator=operator;
                break;
            case "*":
                this.operator=operator;
                break;
            case "/":
                this.operator=operator;
                break;
            case "%":
                this.operator=operator;
                break;
            case "|":
                this.operator=operator;
                break;
            case "^":
                this.operator=operator;
                break;
            case "&":
                this.operator=operator;
                break;
            case "in":
                this.operator=operator;
                break;
            case "instanceof":
                this.operator=operator;
                break;
            default:
                System.err.println("invalid binary operator");
        }
    }
}
/*
"==" | "!=" | "===" | "!=="
         | "<" | "<=" | ">" | ">="
         | "<<" | ">>" | ">>>"
         | "+" | "-" | "*" | "/" | "%"
         | "|" | "^" | "&" | "in"
         | "instanceof"
         */