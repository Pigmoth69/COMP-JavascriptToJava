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

    public static void main(String[] args) throws IOException {

        System.out.println();

        Visitor visitor = new Visitor();

        try (Reader reader = new FileReader("Files/teste.js")) {

            AstRoot node = new Parser().parse(reader, "", 1);
            node.visitAll(visitor);

        }

        main.addCode(visitor.getOutput());

        TypeSpec js2Java = TypeSpec.classBuilder("JS2Java")
                .addModifiers(Modifier.PUBLIC, Modifier.FINAL)
                .addMethod(main.build())
                .build();

        JavaFile javaFile = JavaFile.builder("", js2Java).indent("    ").skipJavaLangImports(true).build();

        System.out.println();
        javaFile.writeTo(System.out);
        javaFile.writeTo(new File("Files/"));

    }

}
