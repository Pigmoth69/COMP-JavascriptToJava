import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.MethodSpec;
import com.squareup.javapoet.TypeSpec;
import org.mozilla.javascript.Parser;
import org.mozilla.javascript.Token;
import org.mozilla.javascript.ast.*;

import javax.lang.model.element.Modifier;
import java.io.*;

public class RhinoTest {

    private static MethodSpec.Builder main = MethodSpec.methodBuilder("main")
            .addModifiers(Modifier.PUBLIC, Modifier.STATIC)
            .returns(void.class)
            .addParameter(String[].class, "args");

    public static void main(String[] args) throws IOException {

        class Printer implements NodeVisitor {

            @Override
            public boolean visit(AstNode node) {

                switch (Token.typeToName(node.getType())) {

                    case "ADD":

                        String a = ((NumberLiteral)((InfixExpression) node).getLeft()).getValue();
                        String b = ((NumberLiteral)((InfixExpression) node).getRight()).getValue();

                        RhinoTest.main.addStatement(a + " + " + b);

                        break;

                }

                return true;
            }

        }

        try (Reader reader = new FileReader("Files/teste.js")) {

            AstRoot node = new Parser().parse(reader, "", 1);
            node.visitAll(new Printer());

        }

        TypeSpec js2Java = TypeSpec.classBuilder("JS2Java")
                .addModifiers(Modifier.PUBLIC, Modifier.FINAL)
                .addMethod(main.build())
                .build();

        JavaFile javaFile = JavaFile.builder("", js2Java).build();

        javaFile.writeTo(System.out);

    }

}
