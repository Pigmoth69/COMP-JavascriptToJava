import com.squareup.javapoet.MethodSpec;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by danny on 05/06/2016.
 */
public class MethodSpecIterable implements Iterable<MethodSpec> {
    ArrayList<MethodSpec> methods = new ArrayList<>();


    @Override
    public Iterator<MethodSpec> iterator() {
        Iterator<MethodSpec> m_method = methods.iterator();
        return m_method;
    }
    public void addMethods(MethodSpec m){
        methods.add(m);
    }

}
