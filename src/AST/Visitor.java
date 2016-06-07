package AST;

import org.apache.commons.lang3.StringUtils;
import org.mozilla.javascript.Node;
import org.mozilla.javascript.Token;
import org.mozilla.javascript.ast.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class Visitor implements NodeVisitor {

    private String output = "";
    private int indentLevel = 0;
    private HashMap<String,ArrayList<String>> localVariablesList = new HashMap<>();
    private HashMap<String,ArrayList<String>> classVariableList = new HashMap<>();
    private ArrayList<Functions> functions = new ArrayList<>();
    //onde encontrarmos $var = --> neste padrão regex, substituimos pelo tipo de variável que queremos

    public String getOutput() {
        return output;
    }

    @Override
    public boolean visit(AstNode node) {

        System.out.println(node.makeIndent(node.depth()) + node.shortName() + " (" + node.getType() + " - " + Token.typeToName(node.getType()) + ")");

        switch (node.shortName()) {

            case "VariableDeclaration":
            case "ExpressionStatement":
            case "IfStatement":
            case "Scope":
            case "ForLoop":
            case "VariableInitializer":
            case "Assignment":
            case "InfixExpression":
            case "UnaryExpression":
            case "FunctionCall":
            case "NumberLiteral":
            case "KeywordLiteral":
            case "Name":
            case "ArrayLiteral":
            case "PropertyGet":
            case "StringLiteral":
            case "ParenthesizedExpression":
            case "WhileLoop":
            case "DoLoop":
            case "SwitchStatement":
            case "SwitchCase":
            case "BreakStatement":
            case "TryStatement":
            case "CatchClause":
            case "Block":
            case "ThrowStatement":
            case "NewExpression":
            case "ObjectLiteral":
            case "ObjectProperty":
            case "FunctionNode":
            case "ReturnStatement":
            case "ElementGet":

                output += print(node);

                return false;

            default:

        }

        return true;

    }

    private String print(AstNode node) {

        switch (node.shortName()) {

            case "VariableDeclaration"       : return print((VariableDeclaration) node);

            case "ExpressionStatement"       : return print((ExpressionStatement) node);

            case "IfStatement"               : return print((IfStatement) node);

            case "Scope"                     : return print((Scope) node);

            case "ForLoop"                   : return print((ForLoop) node);

            case "VariableInitializer"       : return print((VariableInitializer) node);

            case "Assignment"                : return print((Assignment) node);

            case "InfixExpression"           : return print((InfixExpression) node);

            case "UnaryExpression"           : return print((UnaryExpression) node);

            case "FunctionCall"              : return print((FunctionCall) node);

            case "NumberLiteral"             : return print((NumberLiteral) node);

            case "KeywordLiteral"            : return print((KeywordLiteral) node);

            case "Name"                      : return print((Name) node);

            case "ArrayLiteral"              :return print((ArrayLiteral) node);

            case "PropertyGet"               :return print((PropertyGet) node);

            case "StringLiteral"             :return print((StringLiteral) node);

            case "ParenthesizedExpression"   :return print((ParenthesizedExpression) node);

            case "WhileLoop"                 :return print((WhileLoop) node);

            case "DoLoop"                    :return print((DoLoop) node);

            case "SwitchStatement"           :return print((SwitchStatement) node); //--> Ver daqui para baixo pls

            case "SwitchCase"                :return print((SwitchCase) node);

            case "BreakStatement"            :return print((BreakStatement) node);

            case "TryStatement"              :return print((TryStatement) node);

            case "CatchClause"               :return print((CatchClause) node);

            case "Block"                     :return print((Block) node);

            case "ThrowStatement"            :return print((ThrowStatement) node);

            case "NewExpression"             :return print((NewExpression) node);

            case "ObjectLiteral"             :return print((ObjectLiteral) node);

            case "ObjectProperty"            :return print((ObjectProperty) node);

            case "FunctionNode"              :return print((FunctionNode) node);

            case "ReturnStatement"           :return print((ReturnStatement) node);

            case "ElementGet"                :return print((ElementGet) node);

            default                          : return "";

        }

    }

    private String print(ElementGet node){
        return print(node.getTarget())+"["+print(node.getElement())+"]";
    }

    private String print(ReturnStatement node){
        return "return "+print(node.getReturnValue())+";\n";
    }

    private String print(FunctionNode node){
        String funcName = print(node.getFunctionName());
        String body = print(node.getBody());
        ArrayList<String> params = new ArrayList<>();
        for(AstNode n : node.getParams())
            params.add(print(n));
        functions.add(new Functions(funcName,params,body,"null"));

        return "";
    }

    private String print(ObjectProperty node){
        return "ObjectProperty";
    }

    private String print(ObjectLiteral node){
        return "ObjectLiteral";
    }

    private String print(NewExpression node){
        String output = "new ";
        output += print(node.getTarget())+"(";
        List<AstNode> args = node.getArguments();
        for(int i = 0; i < args.size();i++){
            if(args.size()-1 == i)
                output +=print(args.get(i));
            else
                output +=print(args.get(i))+",";
        }
        return output+");\n";
    }

    private String print(ThrowStatement node){
        return "throw "+print(node.getExpression());
    }

    private String print(Block node){
        if(node.getParent() instanceof AstNode){
            String func = parseFunctionBlock(node);
            return func;
        }
        String output = "{\n";
        Iterator<Node> it = node.iterator();
        while(it.hasNext()){
            output+= "    "+print((AstNode)it.next());
            if(it.hasNext())
                output+="\n";
        }
        return output+"}\n";
    }

    private String parseFunctionBlock(Block node) {
        String output = "";
        Iterator<Node> it = node.iterator();
        while(it.hasNext()){
            output+=print((AstNode)it.next());
        }
        return output;
    }

    private String print(CatchClause node){
        String output;
        if(node.getCatchCondition() == null){
            output = "catch(Exception "+print(node.getVarName())+")"+print(node.getBody());
        }else {
            String className = parseClassName(print(node.getVarName()),print(node.getCatchCondition()));
            output = "catch("+className+print(node.getVarName())+")"+ print(node.getBody());
        }
        return output;
    }

    private String parseClassName(String varName, String print) {
            if((varName+" instanceof TypeError").equals(print)){
                return "IOException ";
            }else if((varName+" instanceof RangeError").equals(print)){
                return "IndexOutOfBoundsException ";
            }else if((varName+" instanceof EvalError").equals(print)){
                return "UnsupportedOperationException ";
            }
        return "Exception ";
    }

    private String print(TryStatement node){
        String output = "try"+print(node.getTryBlock());
        List<CatchClause> clauses = node.getCatchClauses();
        for(CatchClause c : clauses){
            output += print(c);
        }
        if(node.getFinallyBlock() != null)
            output += "finnaly"+print(node.getFinallyBlock())+"\n";
        return output;
    }

    private String print(BreakStatement node){
        return "break;";
    }

    private String print(SwitchCase node){
        String output;
        if(node.getExpression() == null) // precisa de ser mudado o ExpressionStatement para aceitar o null !
            output ="    default:";
        else
            output = "    case "+print(node.getExpression());



        List<AstNode> statements = node.getStatements();
        for(AstNode s : statements){
            output += "\n"+"       "+print(s);
        }
        return output;
    }

    private String print(SwitchStatement node){
        String output = "switch("+print(node.getExpression())+"){\n";
        List<SwitchCase> cases = node.getCases();
        for(SwitchCase c : cases){
            output+= print(c)+"\n";
        }
        return output;
    }

    private String print(DoLoop node){
        String output= "do"+print(node.getBody());
        output += "while("+print(node.getCondition())+");\n";
        return output;
    }

    private String print(WhileLoop node){
        String output = "while("+print(node.getCondition())+")";
        output += print(node.getBody());
        return output+"\n";
    }

    private String print(ParenthesizedExpression node){
        return "("+print(node.getExpression())+")";
    }

    private String print(StringLiteral node){
        return node.getValue(true);
    }

    private String print(PropertyGet node){
        if(print(node.getTarget()).equals("console") && print(node.getProperty()).equals("log"))
            return "System.out.println";
        else if(print(node.getTarget()).equals("document") && print(node.getProperty()).equals("write")) {
            return "System.out.println";
        } else {
            System.err.println("Invalid propertyGet! Or user needs to implement that function");//QUANDO ISTO ACONTECE È PORQUE È NECESSÀRIO CRIAR MAIS UM CASO PARA O EXEMPLO
            return print(node.getTarget())+"."+print(node.getProperty());
        }
    }

    private String print(ArrayLiteral node){//ainda não está feita
        String s = "new ArrayList<Integer>(";
        List<AstNode> nodes = node.getElements();
        for(int i = 0; i < nodes.size();i++){
            if(i==nodes.size()-1)
                s+=print(node.getElement(i));
            else
                s+=print(node.getElement(i))+",";
        }
        s+=")";
        return s;
    }

    private String print(ExpressionStatement node) {//estou a fazer identação com esta função. Caso apareça desformatado, pode ser deste código ;)
        return print(node.getExpression()) + ";\n";
    }

    private String print(VariableDeclaration node) {

        String output = "";

        List<VariableInitializer> variables = node.getVariables();

        for (int i = 0; i < variables.size(); i++) {

            if ( i > 0 ) {
                output += ", ";
            }
            String fname = isInsideFunctionNode(node);
            if(fname == null)
                output += ".var. "+print(variables.get(i));
            else {
                output += TypeParser.getFunctionLocalVariableType(fname, getWord(print(variables.get(i)))) + " " + print(variables.get(i));
            }
            //System.err.println(TypeParser.getFunctionLocalVariableType(fname, print(variables.get(i))));
        }

        output += ";";

        if (!(node.getParent() instanceof ForLoop)) {
            output += "\n";
        }
        if(node.getParent() instanceof AstRoot)
            return "";


        return output;

    }
    public String isInsideFunctionNode(AstNode node) {

        AstNode parent = node.getParent();

        if (parent != null) {

            if (parent.shortName().equals("FunctionNode")) {
                return ((FunctionNode)parent).getFunctionName().getIdentifier();
            } else {
                return isInsideFunctionNode(parent);
            }

        } else {
            return null;
        }

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
            output += print(node.getInitializer())+";";
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
            String initializer = print(node.getInitializer());
            if(node.getParent().getParent() instanceof AstRoot)
                addVariable(classVariableList,output,initializer);
            else
                addVariable(localVariablesList,output,initializer);
            output += " = " + initializer;
        }else{
            if(node.getParent().getParent() instanceof AstRoot)
                addVariable(classVariableList,output,null);
            else
                addVariable(localVariablesList,output,null);
        }

        return output;

    }

    private String print(Assignment node) {
        String nodeRight,nodeLeft;
        nodeRight= print(node.getRight());
        nodeLeft=print(node.getLeft());
        addVariable(localVariablesList,nodeLeft,nodeRight);         //PODE TER ERRO AQUI QUANDO CHEGAR À ALTURA DE ATRIBUIR TIPO DE VARIÀVEIS!
        return  nodeLeft+ " = " + nodeRight;

    }

    private String print(InfixExpression node) {

        String operator="";


        switch (node.getType()) {

            case Token.ADD          : operator += "+";          break;

            case Token.SUB          : operator += "-";          break;

            case Token.MUL          : operator += "*";          break;

            case Token.DIV          : operator += "/";          break;

            case Token.EQ           : operator += "==";         break;

            case Token.NE           : operator += "!=";         break;

            case Token.LT           : operator += "<";          break;

            case Token.GT           : operator += ">";          break;

            case Token.LE           : operator += "<=";         break;

            case Token.GE           : operator += ">=";         break;

            case Token.INSTANCEOF   : operator += "instanceof"; break;

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

    public HashMap<String,ArrayList<String>> getLocalVariablesList(){
        return localVariablesList;
    }

    private void addVariable(HashMap<String,ArrayList<String>> h,String variableName, String variableValue) {
        if(h.containsKey(variableName)){
            ArrayList<String> temp = h.get(variableName);
            temp.add(variableValue);
            h.put(variableName,temp);
        }else{
            ArrayList<String> temp = new ArrayList<>();
            temp.add(variableValue);
            h.put(variableName,temp);
        }
    }

    public HashMap<String,ArrayList<String>> getClassVariableList(){
        return classVariableList;
    }

    public ArrayList<Functions> getFunctions(){
        return functions;
    }

    public String getWord(String s){
        String res = new String();
        for(int i = 0; i < s.length();i++){
            if(s.charAt(i) == ' '|| s.charAt(i)== '=')
                return res;
            else
                res= res+""+s.charAt(i);
        }
        return null;
    }

}