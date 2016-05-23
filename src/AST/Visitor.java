package AST;

import org.mozilla.javascript.Token;
import org.mozilla.javascript.ast.AstNode;
import org.mozilla.javascript.ast.NodeVisitor;
import org.mozilla.javascript.ast.NumberLiteral;

public class Visitor implements NodeVisitor {

    @Override
    public boolean visit(AstNode node) {

        System.out.println(node.makeIndent(node.depth()) + node.shortName() + " (" + node.getType() + " - " + Token.typeToName(node.getType()) + ")");

        

        return true;

    }

    private String print(NumberLiteral node) {

        return node.getValue();

    }

    private String printInfixExpression(AstNode node) {

        return "";

    }

}