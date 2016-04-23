package ESTree.Literal;

import jdk.nashorn.internal.runtime.regexp.RegExp;

/**
 * Created by danny on 21/04/2016.
 */
public class Literal implements  Expression{
    private String type = "Literal";
    private String valueType;/*string | boolean | null | number | RegExp*/
    private String value1;
    private boolean value2;
    private double value3;
    private RegExp value4;

}
/*
* interface Literal <: Expression {
    type: "Literal";
    value: string | boolean | null | number | RegExp;
}*/