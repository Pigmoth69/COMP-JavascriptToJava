import AST.Visitor;
import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.MethodSpec;
import com.squareup.javapoet.TypeSpec;
import org.mozilla.javascript.Parser;
import org.mozilla.javascript.ast.AstRoot;

import javax.lang.model.element.Modifier;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class RhinoTest {


    private static MethodSpec.Builder main = MethodSpec.methodBuilder("main")
            .addModifiers(Modifier.PUBLIC, Modifier.STATIC)
            .returns(void.class)
            .addParameter(String[].class, "args");

    private static MethodSpec functionMethods(String name) {
        return MethodSpec.methodBuilder(name)
                .returns(String.class)
                .addStatement("return $S", name)
                .build();
    }

    public static void main(String[] args) throws IOException {

        System.out.println();

        Visitor visitor = new Visitor();

        try (Reader reader = new FileReader("Files/teste.js")) {

            AstRoot node = new Parser().parse(reader, "", 1);
            node.visitAll(visitor);
            System.out.println("Program Variables: ");
            System.out.println(visitor.getVariablesList());
        }

        main.addCode(visitor.getOutput());



        /*MethodSpecIterable m = new MethodSpecIterable();
        for(int i = 0; i < visitor.getFunctions().size();i++){

            MethodSpec.Builder method = MethodSpec.methodBuilder("hexDigit")
                    .addParameter(int.class, "i")
                    .returns(char.class)
                    .addStatement(visitor.getOutput());

            m.addMethods(method);
        }*/



        TypeSpec js2Java= TypeSpec.classBuilder("JS2Java")
                .addModifiers(Modifier.PUBLIC, Modifier.FINAL)
                .addMethod(main.build())/*.addMethods(m)*/
                .build();


        System.out.println("Tamanho: "+js2Java.methodSpecs.size());

        JavaFile javaFile  = JavaFile.builder("", js2Java).indent("    ").skipJavaLangImports(true).build();
        System.out.println();
        javaFile.writeTo(System.out);
        javaFile.writeTo(new File("Files/"));

    }

}
