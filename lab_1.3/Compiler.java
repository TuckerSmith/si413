import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Stack;

// The main interpreter class for DRAMAQUEEN.
public class Compiler {
    private static Scanner sharedScanner = new Scanner(System.in); // MARKED CHANGE: Re-added sharedScanner to make the Evaluator class compile

    public static void main(String[] args) {
        if(args.length != 2){
            System.err.println("Usage: java Compiler <source.prog> <compiled.ll>");
            return;
        }

        File inputFile = new File(args[0]);
        if (!inputFile.exists()) {
            System.err.println("Error: File not found: " + args[0]);
            return;
        }
        
        File outputFile = new File(args[1]);

        try {
            processFile(inputFile, outputFile);
        } catch (IOException e) {
            System.err.println("Error reading/writing file: " + e.getMessage());
        } catch (ParseException e) {
            System.err.println("Parse Error: " + e.getMessage());
        }
    }

    public static void processFile(File inputFile, File outputFile) throws IOException, ParseException {
        BufferedReader reader = new BufferedReader(new FileReader(inputFile));
        StringBuilder fileContent = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            fileContent.append(line).append("\n");
        }
        reader.close();

        String code = removeComments(fileContent.toString());
        if (!code.trim().isEmpty()) {
            compileCode(code, outputFile);
        }
    }

    private static void compileCode(String code, File outputFile) throws ParseException, IOException {
        List<Token> tokens = Tokenizer.tokenize(code);
        if (tokens.isEmpty()) {
            return;
        }

        Parser parser = new Parser(tokens);
        List<Node> statements = parser.parse();
        
        // TODO: In the next step, the AST will be traversed to generate LLVM IR.
        // MARKED CHANGE: We now use the Evaluator to trigger the exceptions.
        Evaluator evaluator = new Evaluator(sharedScanner);
        for (Node statement : statements) {
            evaluator.evaluate(statement);
        }
        
        String llvmIR = "; Placeholder for LLVM IR code\n";
        
        try (FileWriter writer = new FileWriter(outputFile)) {
            writer.write(llvmIR);
        }
    }
    
    public static String removeComments(String input) {
        Pattern pattern = Pattern.compile("shhh.*?shhh", Pattern.DOTALL);
        Matcher matcher = pattern.matcher(input);
        String noComments = matcher.replaceAll("");
        if (noComments.contains("shhh")) {
             return noComments.substring(0, noComments.indexOf("shhh"));
        }
        return noComments;
    }
}

// Represents different types of tokens in the DRAMAQUEEN language.
enum TokenType {
    HEAR_YE, REVERTERE, UNIFY, GIVE_ME, STRING_LITERAL, OPEN_PAREN, CLOSE_PAREN, EOF,
    // For parsing
    MAGIC_WORD
}

// A token, consisting of a type and a value.
class Token {
    public final TokenType type;
    public final String value;

    public Token(TokenType type, String value) {
        this.type = type;
        this.value = value;
    }

    @Override
    public String toString() {
        return "Token(" + type + ", \"" + value + "\")";
    }
}

// Custom exception for parsing errors.
class ParseException extends Exception {
    public ParseException(String message) {
        super(message);
    }
}

// Tokenizer to convert the input string into a list of tokens.
class Tokenizer {
    public static List<Token> tokenize(String input) throws ParseException {
        List<Token> tokens = new ArrayList<>();
        // This regex correctly captures string literals, keywords, and parentheses.
        // It handles the magic word and the required spaces.
        Pattern pattern = Pattern.compile("~([A-Z]*)\\s(.*?)\\s~\\1|HEAR_YE|REVERTERE|UNIFY|GIVE_ME|\\(|\\)|\\s+");
        Matcher matcher = pattern.matcher(input);

        while (matcher.find()) {
            String tokenValue = matcher.group();
            if (tokenValue.matches("\\s+")) {
                continue;
            } else if (tokenValue.equals("HEAR_YE")) {
                tokens.add(new Token(TokenType.HEAR_YE, "HEAR_YE"));
            } else if (tokenValue.equals("REVERTERE")) {
                tokens.add(new Token(TokenType.REVERTERE, "REVERTERE"));
            } else if (tokenValue.equals("UNIFY")) {
                tokens.add(new Token(TokenType.UNIFY, "UNIFY"));
            } else if (tokenValue.equals("GIVE_ME")) {
                tokens.add(new Token(TokenType.GIVE_ME, "GIVE_ME"));
            } else if (tokenValue.equals("(")) {
                tokens.add(new Token(TokenType.OPEN_PAREN, "("));
            } else if (tokenValue.equals(")")) {
                tokens.add(new Token(TokenType.CLOSE_PAREN, ")"));
            } else if (tokenValue.startsWith("~")) {
                String magicWord = matcher.group(1);
                String content = matcher.group(2);
                tokens.add(new Token(TokenType.STRING_LITERAL, content));
            } else {
                throw new ParseException("Unrecognized token: " + tokenValue);
            }
        }
        tokens.add(new Token(TokenType.EOF, ""));
        return tokens;
    }
}

// AST Node classes.
interface Node {
    // Empty interface to define the AST node types
}

class ExpressionNode implements Node {
    public final TokenType type;
    public final String value;
    public List<Node> children;

    public ExpressionNode(TokenType type, String value) {
        this.type = type;
        this.value = value;
        this.children = new ArrayList<>();
    }
}

class StatementNode implements Node {
    public final TokenType type;
    public Node child;

    public StatementNode(TokenType type, Node child) {
        this.type = type;
        this.child = child;
    }
}

// Parser to build an AST from a list of tokens.
class Parser {
    private final List<Token> tokens;
    private int currentTokenIndex;

    public Parser(List<Token> tokens) {
        this.tokens = tokens;
        this.currentTokenIndex = 0;
    }

    private Token consume() throws ParseException {
        if (currentTokenIndex >= tokens.size()) {
            throw new ParseException("Unexpected end of input");
        }
        return tokens.get(currentTokenIndex++);
    }

    private Token peek() {
        if (currentTokenIndex >= tokens.size()) {
            return new Token(TokenType.EOF, "");
        }
        return tokens.get(currentTokenIndex);
    }

    public List<Node> parse() throws ParseException {
        List<Node> statements = new ArrayList<>();
        while (peek().type != TokenType.EOF) {
            statements.add(parseStatement());
        }
        return statements;
    }

    private Node parseStatement() throws ParseException {
        Token token = peek();
        if (token.type == TokenType.HEAR_YE) {
            consume(); // Consume HEAR_YE
            consume(TokenType.OPEN_PAREN);
            Node expression = parseExpression();
            consume(TokenType.CLOSE_PAREN);
            return new StatementNode(TokenType.HEAR_YE, expression);
        }
        throw new ParseException("Expected HEAR_YE statement, got " + token.type);
    }
    
    private void consume(TokenType type) throws ParseException {
        if (peek().type == type) {
            consume();
        } else {
            throw new ParseException("Expected " + type + ", got " + peek().type);
        }
    }

    private Node parseExpression() throws ParseException {
        Node left = parsePrimaryExpression();
        while (peek().type == TokenType.UNIFY) {
            Token unifyToken = consume();
            Node right = parsePrimaryExpression();
            ExpressionNode unifyNode = new ExpressionNode(TokenType.UNIFY, unifyToken.value);
            unifyNode.children.add(left);
            unifyNode.children.add(right);
            left = unifyNode;
        }
        return left;
    }
    
    private Node parsePrimaryExpression() throws ParseException {
        Token token = peek();
        if (token.type == TokenType.STRING_LITERAL) {
            return new ExpressionNode(TokenType.STRING_LITERAL, consume().value);
        } else if (token.type == TokenType.GIVE_ME) {
            return new ExpressionNode(TokenType.GIVE_ME, consume().value);
        } else if (token.type == TokenType.REVERTERE) {
            return parseFunctionCall(TokenType.REVERTERE);
        } else if (token.type == TokenType.OPEN_PAREN) {
            consume();
            Node expr = parseExpression();
            consume(TokenType.CLOSE_PAREN);
            return expr;
        }
        throw new ParseException("Unexpected token: " + token.type);
    }
    
    private Node parseFunctionCall(TokenType functionType) throws ParseException {
        consume(); // Consume function name (e.g., REVERTERE)
        consume(TokenType.OPEN_PAREN);
        Node argument = parseExpression();
        consume(TokenType.CLOSE_PAREN);

        ExpressionNode functionNode = new ExpressionNode(functionType, "");
        functionNode.children.add(argument);
        return functionNode;
    }
}

// Evaluates the AST to compute the results.
class Evaluator {
    private final Scanner scanner;

    public Evaluator(Scanner scanner) {
        this.scanner = scanner;
    }

    public void evaluate(Node node) throws ParseException {
        if (node instanceof StatementNode) {
            StatementNode statement = (StatementNode) node;
            if (statement.type == TokenType.HEAR_YE) {
                String result = evaluateExpression(statement.child);
                // MARKED CHANGE: Replaced print statement with exception
                // System.out.println(result);
                throw new UnsupportedOperationException("this doesn't work yet");
            }
        } else {
            throw new ParseException("Invalid statement type: " + node.getClass().getName());
        }
    }

    private String evaluateExpression(Node node) throws ParseException {
        if (node instanceof ExpressionNode) {
            ExpressionNode expr = (ExpressionNode) node;
            switch (expr.type) {
                case STRING_LITERAL:
                    return expr.value;
                case GIVE_ME:
                    // MARKED CHANGE: Replaced GIVE_ME call with exception
                    // return GIVE_ME();
                    throw new UnsupportedOperationException("this doesn't work yet");
                case UNIFY:
                    String left = evaluateExpression(expr.children.get(0));
                    String right = evaluateExpression(expr.children.get(1));
                    // MARKED CHANGE: Replaced concatenation with exception
                    // return left + right;
                    throw new UnsupportedOperationException("this doesn't work yet");
                case REVERTERE:
                    String argument = evaluateExpression(expr.children.get(0));
                    // MARKED CHANGE: Replaced REVERTERE call with exception
                    // return REVERTERE(argument);
                    throw new UnsupportedOperationException("this doesn't work yet");
                default:
                    throw new ParseException("Unknown expression type: " + expr.type);
            }
        }
        throw new ParseException("Invalid expression type: " + node.getClass().getName());
    }

    // MARKED CHANGE: Replaced GIVE_ME body with exception
    private String GIVE_ME() {
        // return scanner.nextLine();
        throw new UnsupportedOperationException("this doesn't work yet");
    }
    
    // MARKED CHANGE: Replaced REVERTERE body with exception
    private String REVERTERE(String input) {
        // StringBuilder reversed = new StringBuilder(input);
        // return reversed.reverse().toString();
        throw new UnsupportedOperationException("this doesn't work yet");
    }
}