package AST;


import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;

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
                t = getTypeVariable("ArrayList<String>");
                break;
            case "int[]":
                t = getTypeVariable("ArrayList<Integer>");
                break;
            case "double[]":
                t = getTypeVariable("ArrayList<Double>");
                break;
            case "char":
                t = char.class;
                break;
            case "char[]":
                t = getTypeVariable("ArrayList<Character>");
                break;
            case "Exception":
                t = Exception.class;
                break;
            default:
               t=null;
                break;
        }
        return t;
    }

    private static Type getTypeVariable(final String typeName){
    Type t = new TypeVariable<StArray>() {
        @Override
        public <T extends Annotation> T getAnnotation(Class<T> annotationClass) {
            return null;
        }

        @Override
        public Annotation[] getAnnotations() {
            return new Annotation[0];
        }

        @Override
        public Annotation[] getDeclaredAnnotations() {
            return new Annotation[0];
        }

        @Override
        public Type[] getBounds() {
            return new Type[0];
        }

        @Override
        public StArray getGenericDeclaration() {
            return null;
        }

        @Override
        public String getName() {
            return typeName;
        }

        @Override
        public AnnotatedType[] getAnnotatedBounds() {
            return new AnnotatedType[0];
        }
    };
        return t;
    }



}
