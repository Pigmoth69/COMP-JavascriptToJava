package ESTree.Literal;

import ESTree.Expressions.Expression;

/**
 * Created by danny on 21/04/2016.
 */
public class Literal extends Expression {
    private String type = "Literal";
    private String valueType;/*string | boolean | null | number | RegExp*/
    private String value1;
    private boolean value2;
    private double value3;
    private RegExpLiteral value4;

    public Literal() {
        super("Literal");
    }
}
/*
* interface Literal <: Expression {
    type: "Literal";
    value: string | boolean | null | number | RegExp;
}*/