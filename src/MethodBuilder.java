import com.squareup.javapoet.MethodSpec;

import javax.lang.model.element.Modifier;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by danny on 06/06/2016.
 */
public class MethodBuilder implements Iterable<MethodSpec> {
    ArrayList<MethodSpec> methods = new ArrayList<>();

    public MethodBuilder(){

    }

    @Override
    public Iterator<MethodSpec> iterator() {
        Iterator<MethodSpec> m_method = methods.iterator();
        return m_method;
    }
    public void addMethods(String name, ArrayList<String> res, ArrayList<String> params, String body, String returnType){
        Type t = null;
        switch(returnType){
            case "int":
                t = int.class;
                break;
            case "String":
                t = String.class;
                break;
            case "double":
                t = double.class;
                break;
            case "Exception":
                t = Exception.class;
                break;
            default:
        }
        MethodSpec.Builder method = MethodSpec.methodBuilder(name).addModifiers(Modifier.PUBLIC,Modifier.STATIC);
        for(int i = 0; i < params.size();i++){
            method.addParameter(getType(res.get(i)), params.get(i)); // needs to check the JSON file(it still needs to be created!)
        }
        System.err.println("Erro: "+returnType);
        if(!returnType.equals("null") || t != null)
            method.returns(t);
        method.addCode(body);

        methods.add(method.build());
    }

    private Type getType(String t){
        Type tp = null;
        switch(t){
            case "int":
                tp = int.class;
                break;
            case "String":
                tp = String.class;
                break;
            case "double":
                tp = double.class;
                break;
            case "Exception":
                tp = Exception.class;
                break;
            default:
        }
        return tp;
    }

}