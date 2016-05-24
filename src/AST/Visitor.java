package AST;

import org.apache.commons.lang3.StringUtils;
import org.mozilla.javascript.Token;
import org.mozilla.javascript.ast.*;

import java.util.List;

public class Visitor implements NodeVisitor {

    private String output = "";
    private int indentLevel = 0;

    public String getOutput() {
        return output;
    }

    @Override
    public boolean visit(AstNode node) {

        System.out.println(node.makeIndent(node.depth()) + node.shortName() + " (" + node.getType() + " - " + Token.typeToName(node.getType()) + ")");

        switch (node.shortName()) {

            case "ExpressionStatement":
            case "VariableDeclaration":
            case "IfStatement":
            case "ForLoop":

                output += print(node);

                return false;

            default:

        }

        return true;

    }

    private String print(AstNode node) {

        switch (node.shortName()) {

            case "VariableDeclaration"    : return print((VariableDeclaration) node);

            case "ExpressionStatement"    : return print((ExpressionStatement) node);

            case "IfStatement"            : return print((IfStatement) node);

            case "Scope"                  : return print((Scope) node);

            case "ForLoop"                : return print((ForLoop) node);

            case "VariableInitializer"    : return print((VariableInitializer) node);

            case "Assignment"             : return print((Assignment) node);

            case "InfixExpression"        : return print((InfixExpression) node);

            case "UnaryExpression"        : return print((UnaryExpression) node);

            case "FunctionCall"           : return print((FunctionCall) node);

            case "NumberLiteral"          : return print((NumberLiteral) node);

            case "KeywordLiteral"         : return print((KeywordLiteral) node);

            case "Name"                   : return print((Name) node);

            default                       : return "";

        }

    }

    private String print(ExpressionStatement node) {

        return print(node.getExpression()) + ";\n";

    }

    private String print(VariableDeclaration node) {

        String output = "int ";

        List<VariableInitializer> variables = node.getVariables();

        for (int i = 0; i < variables.size(); i++) {

            if ( i > 0 ) {
                output += ", ";
            }

            output += print(variables.get(i));

        }

        output += ";";

        if (!(node.getParent() instanceof ForLoop)) {
            output += "\n";
        }

        return output;

    }

    private String print(IfStatement node) {

        String output = "if (" + print(node.getCondition()) + ") " + print(node.getThenPart());

        if (node.getElsePart() != null) {

            output += " else " + print(node.getElsePart());

        }

        return output + "\n";

    }

    private String print(Scope node) {

        int indentSize = 4;

        indentLevel++;

        String output = "{";

        List<AstNode> statements = node.getStatements();

        for (AstNode statement : statements) {

            output += "\n" + StringUtils.repeat(" ", indentLevel * indentSize) + print(statement);

        }

        indentLevel--;

        return output += StringUtils.repeat(" ", indentLevel * indentSize) + "}";

    }

    private String print(ForLoop node) {

        String output = "for (";

        if (node.getInitializer() != null) {
            output += print(node.getInitializer());
        } else {
            output += ";";
        }

        if (node.getCondition() != null) {
            output += " " + print(node.getCondition());
        }

        output += ";";

        if (node.getIncrement() != null) {
            output += " " + print(node.getIncrement());
        }

        output += ") " + print(node.getBody());

        return output + "\n";

    }

    private String print(VariableInitializer node) {

        String output = print(node.getTarget());

        if (node.getInitializer() != null) {
            output += " = " + print(node.getInitializer());
        }

        return output;

    }

    private String print(Assignment node) {

        return print(node.getLeft()) + " = " + print(node.getRight());

    }

    private String print(InfixExpression node) {

        String operator;

        switch (node.getType()) {

            case Token.ADD    : operator = "+"; break;

            case Token.SUB    : operator = "-"; break;

            case Token.MUL    : operator = "*"; break;

            case Token.DIV    : operator = "/"; break;

            case Token.EQ     : operator = "=="; break;

            case Token.NE     : operator = "!="; break;

            case Token.LT     : operator = "<"; break;

            case Token.GT     : operator = ">"; break;

            case Token.LE     : operator = "<="; break;

            case Token.GE     : operator = ">="; break;

            default           : return "";

        }

        return print(node.getLeft()) + " " + operator + " " + print(node.getRight());

    }

    private String print(UnaryExpression node) {

        String operator;

        switch (node.getType()) {

            case Token.INC    : operator = "++"; break;

            case Token.DEC    : operator = "--"; break;

            default           : return "";

        }

        return print(node.getOperand()) + operator;

    }

    private String print(FunctionCall node) {

        String output = print(node.getTarget()) + "(";

        List<AstNode> arguments = node.getArguments();

        for (int i = 0; i < arguments.size(); i++) {

            if ( i > 0 ) {
                output += ", ";
            }

            output += print(arguments.get(i));

        }

        return output + ")";

    }

    private String print(NumberLiteral node) {

        return node.getValue();

    }

    private String print(KeywordLiteral node) {

        return Token.typeToName(node.getType()).toLowerCase();

    }

    private String print(Name node) {

        return node.getIdentifier();

    }

}