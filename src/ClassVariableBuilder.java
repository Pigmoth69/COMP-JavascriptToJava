import com.squareup.javapoet.FieldSpec;

import javax.lang.model.element.Modifier;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by danny on 06/06/2016.
 */
public class ClassVariableBuilder implements Iterable<FieldSpec>{

    ArrayList<FieldSpec> classVariables = new ArrayList<>();

    public ClassVariableBuilder(){

    }

    @Override
    public Iterator<FieldSpec> iterator() {
        Iterator<FieldSpec> m_classVars = classVariables.iterator();
        return m_classVars;
    }

    public void addClassVariable(String type,String name,String value){
        Type t;
        switch (type){
            case "int":
                t=Integer.class;
                break;
            case "String":
                t= String.class;
                break;  
            case "double":
                t=double.class; // is this right?
                break;
            default:
                t = String.class;
        }
        FieldSpec.Builder var = FieldSpec.builder(t, name) //String.class Int.class boolean.class
                .addModifiers(Modifier.PRIVATE).initializer(value);
        classVariables.add(var.build());
    }

}
