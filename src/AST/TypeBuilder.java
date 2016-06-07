package AST;


import java.lang.reflect.Type;

/**
 * Created by danny on 07/06/2016.
 */
public class TypeBuilder {

    public TypeBuilder(){
    }

    public static Type getType(String type){
        Type t;
        switch (type){
            case "int":
                t=int.class;
                break;
            case "String":
                t= String.class;
                break;
            case "double":
                t=double.class;
                break;
            case "String[]":
                t = String[].class;
                break;
            case "int[]":
                t = int[].class;
                break;
            case "double[]":
                t = double[].class;
                break;
            case "char":
                t = char.class;
                break;
            case "char[]":
                t = char[].class;
                break;
            default:
               t=null;
                break;
        }
        return t;
    }
}
