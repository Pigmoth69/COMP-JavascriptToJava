import AST.Functions;
import AST.TypeParser;
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
import java.util.ArrayList;

public class RhinoTest {

    private static MethodSpec.Builder main = MethodSpec.methodBuilder("main")
            .addModifiers(Modifier.PUBLIC, Modifier.STATIC)
            .returns(void.class)
            .addParameter(String[].class, "args");

    public static void main(String[] args) throws IOException {

        System.out.println();
        TypeParser.init();
        Visitor visitor = new Visitor();

        try (Reader reader = new FileReader("Files/teste.js")) {

            AstRoot node = new Parser().parse(reader, "", 1);
            node.visitAll(visitor);
        }
        System.out.println("Class Variables: ");
        System.out.println(visitor.getClassVariableList());
        System.out.println("local Variables: ");
        System.out.println(visitor.getLocalVariablesList());

        main.addCode(visitor.getOutput());
        ClassVariableBuilder classVars = new ClassVariableBuilder();
        for (String key : visitor.getClassVariableList().keySet()) {
            String type = TypeParser.getGlobalVariableType(key);
            classVars.addClassVariable(type,key,visitor.getClassVariableList().get(key).get(0));//vai buscar o primeiro valor a ser atribuido à variável!
        }

        MethodBuilder m = new MethodBuilder();
        ArrayList<Functions> f = visitor.getFunctions();
        for(int i = 0; i < f.size();i++){
            ArrayList<String> res = new ArrayList<>();
            for(int x = 0; x < f.get(i).getParameters().size();x++){
                res.add(TypeParser.getFunctionArgumentType(f.get(i).getFunctionName(),f.get(i).getParameters().get(x)));
            }

            String returnType;

            if(TypeParser.getFunctionReturnType(f.get(i).getFunctionName())==null)
                returnType=f.get(i).getReturnType();
            else
                returnType = TypeParser.getFunctionReturnType(f.get(i).getFunctionName());
            m.addMethods(f.get(i).getFunctionName(),res,f.get(i).getParameters(),f.get(i).getBody(),returnType);
        }



        TypeSpec js2Java= TypeSpec.classBuilder("JS2Java")
                .addModifiers(Modifier.PUBLIC, Modifier.FINAL)
                .addMethod(main.build()).addFields(classVars).addMethods(m)
                .build();


        System.out.println("Tamanho: "+js2Java.methodSpecs.size());

        JavaFile javaFile  = JavaFile.builder("", js2Java).indent("    ").skipJavaLangImports(true).build();
        System.out.println();
        javaFile.writeTo(System.out);
        javaFile.writeTo(new File("Files/"));

    }

}
