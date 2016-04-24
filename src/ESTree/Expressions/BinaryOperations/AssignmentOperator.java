package ESTree.Expressions.BinaryOperations;

/**
 * Created by danny on 24/04/2016.
 */
public class AssignmentOperator {
    private String operator;

    public AssignmentOperator(String operator){
        switch(operator){
            case "=":
                this.operator=operator;
                break;
            case "+=":
                this.operator=operator;
                break;
            case "-=":
                this.operator=operator;
                break;
            case "*=":
                this.operator=operator;
                break;
            case "/=":
                this.operator=operator;
                break;
            case "%=":
                this.operator=operator;
                break;
            case "<<=":
                this.operator=operator;
                break;
            case ">>=":
                this.operator=operator;
                break;
            case ">>>=":
                this.operator=operator;
                break;
            case "|=":
                this.operator=operator;
                break;
            case "^=":
                this.operator=operator;
                break;
            case "&=":
                this.operator=operator;
                break;
            default:
                System.err.println("Invalid AssignmentOperator");
        }
    }
}
/*
 "=" | "+=" | "-=" | "*=" | "/=" | "%="
        | "<<=" | ">>=" | ">>>="
        | "|=" | "^=" | "&="
        */