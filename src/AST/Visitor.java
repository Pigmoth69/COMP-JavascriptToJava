package AST;

import org.mozilla.javascript.Token;
import org.mozilla.javascript.ast.AstNode;
import org.mozilla.javascript.ast.InfixExpression;
import org.mozilla.javascript.ast.NodeVisitor;
import org.mozilla.javascript.ast.NumberLiteral;

public class Visitor implements NodeVisitor {

    @Override
    public boolean visit(AstNode node) {

        System.out.println(node.makeIndent(node.depth()) + node.shortName() + " (" + node.getType() + " - " + Token.typeToName(node.getType()) + ")");

        switch (node.shortName()) {

            case "InfixExpression":

                return false;

            default:

        }

        return true;

    }

    private String print(AstNode node) {

        switch (node.shortName()) {

            case "InfixExpression":

                return print((InfixExpression) node);

            case "NumberLiteral":

                return print((NumberLiteral) node);

            default:

        }

        return "";

    }

    private String print(NumberLiteral node) {

        return node.getValue();

    }

    private String print(InfixExpression node) {

        String operator;

        switch (node.getType()) {

            case Token.ADD:
                operator = "+";
                break;

            case Token.SUB:
                operator = "-";
                break;

            case Token.MUL:
                operator = "*";
                break;

            case Token.DIV:
                operator = "/";
                break;

            default:
                return "";

        }

        return print(node.getLeft()) + operator + print(node.getRight());

    }

}