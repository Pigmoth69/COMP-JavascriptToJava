import AST.TypeBuilder;
import com.squareup.javapoet.FieldSpec;

import javax.lang.model.element.Modifier;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by danny on 06/06/2016.
 */
public class ClassVariableBuilder extends TypeBuilder implements Iterable<FieldSpec> {

    ArrayList<FieldSpec> classVariables = new ArrayList<>();

    public ClassVariableBuilder(){

    }

    @Override
    public Iterator<FieldSpec> iterator() {
        Iterator<FieldSpec> m_classVars = classVariables.iterator();
        return m_classVars;
    }

    public void addClassVariable(String type,String name,String value){
        Type t = TypeBuilder.getType(type);
        FieldSpec.Builder var = FieldSpec.builder(t, name) //String.class Int.class boolean.class
                .addModifiers(Modifier.PRIVATE,Modifier.STATIC).initializer(value);
        classVariables.add(var.build());
    }

}
