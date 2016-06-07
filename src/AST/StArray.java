package AST;

import java.lang.annotation.Annotation;
import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.TypeVariable;

/**
 * Created by danny on 07/06/2016.
 */
public class StArray implements GenericDeclaration {

    @Override
    public TypeVariable<?>[] getTypeParameters() {
        return new TypeVariable<?>[0];
    }

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
}
