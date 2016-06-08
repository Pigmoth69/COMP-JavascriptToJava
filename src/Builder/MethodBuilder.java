package Builder;

import com.squareup.javapoet.MethodSpec;

import javax.lang.model.element.Modifier;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by danny on 06/06/2016.
 */
public class MethodBuilder extends TypeBuilder implements Iterable<MethodSpec> {
    ArrayList<MethodSpec> methods = new ArrayList<>();

    public MethodBuilder(){

    }

    @Override
    public Iterator<MethodSpec> iterator() {
        Iterator<MethodSpec> m_method = methods.iterator();
        return m_method;
    }
    public void addMethods(String name, ArrayList<String> res, ArrayList<String> params, String body, String returnType){
        Type t;
        t = TypeBuilder.getType(returnType);
        MethodSpec.Builder method = MethodSpec.methodBuilder(name).addModifiers(Modifier.PUBLIC,Modifier.STATIC);
        for(int i = 0; i < params.size();i++){
            method.addParameter(TypeBuilder.getType(res.get(i)), params.get(i)); // needs to check the JSON file(it still needs to be created!)
        }
        if(!returnType.equals("null") || t != null)
            method.returns(t);
        method.addCode(body);

        methods.add(method.build());
    }
}