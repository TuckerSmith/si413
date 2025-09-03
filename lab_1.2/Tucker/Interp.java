import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.*;

//Interpreter for DRAMAQUEEN language
public class Interp {
    public static void main(String[] args) {
        if(args.length == 0){
            interactiveMode();
        } else {
            // Check if the input file exists
            File inputFile = new File(args[0]);
            if (!inputFile.exists()) {
                System.err.println("Error: File not found: " + args[0]);
                return;
            }
            try {
                processFile(inputFile);
            } catch (IOException e) {
                System.err.println("Error reading file: " + e.getMessage());
            }
        }
    }

    public static void interactiveMode() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("DRAMAQUEEN v1.0.0");
        StringBuilder commandBuilder = new StringBuilder();
        while (true) {
            System.out.print("~~");
            String line = scanner.nextLine();
            
            // Check for "shhh" to see if a multi-line command is starting
            if (line.trim().startsWith("shhh") && !line.trim().endsWith("shhh")) {
                commandBuilder.append(line).append("\n");
                System.out.println("... (multi-line comment)");
                while (true) {
                    System.out.print("~-");
                    String continuedLine = scanner.nextLine();
                    commandBuilder.append(continuedLine).append("\n");
                    if (continuedLine.contains("shhh")) {
                        break;
                    }
                }
            } else {
                commandBuilder.append(line).append("\n");
            }
            
            String fullCommand = commandBuilder.toString().trim();
            if (fullCommand.equals("quit")) {
                break;
            }
            
            // Remove comments and execute the cleaned command
            String cleanedCommand = removeComments(fullCommand);
            if (!cleanedCommand.trim().isEmpty()) {
                parseAndExecute(cleanedCommand);
            }
            
            // Reset for the next command
            commandBuilder = new StringBuilder();
        }
        scanner.close();
    }

   public static void processFile(File file) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(file));
        StringBuilder fileContent = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            fileContent.append(line).append("\n"); // Append each line and a newline
        }
        reader.close();
        String code = removeComments(fileContent.toString()); // Remove all comments
        String[] lines = code.split("\n");
        for (String codeLine : lines) {
            if (!codeLine.trim().isEmpty()) { // Ensure we don't process empty lines
                parseAndExecute(codeLine);
            }
        }
    }

    // I used genAI for this
    public static void parseAndExecute(String line) {
        String[] cmd = line.split("\\s+");
        // parse input
        for (int i = 0; i < cmd.length; i++) {
            if (cmd[i].contains("HEAR_YE(")) {
                String[] funargs = parseArgs(Arrays.copyOfRange(cmd, i, cmd.length));
                HEAR_YE(funargs);
                System.out.println();
                return;
            }
        }
        System.out.println();
    }

    //Updated using
    public static String[] parseArgs(String[] cmd) {
        String fullCommand = String.join(" ", cmd);
        int openParenIndex = fullCommand.indexOf('(');
        int closeParenIndex = fullCommand.lastIndexOf(')');

        if (openParenIndex == -1 || closeParenIndex <= openParenIndex) {
            return new String[0];
        }

        String argsContent = fullCommand.substring(openParenIndex + 1, closeParenIndex).trim();
        if (argsContent.isEmpty()) {
            return new String[0];
        }

        List<String> argsList = new ArrayList<>();
        int i = 0;
        while (i < argsContent.length()) {
            char currentChar = argsContent.charAt(i);

            if (currentChar == '~') {
                int nextTildeIndex = argsContent.indexOf('~', i + 1);
                if (nextTildeIndex != -1) {
                    // Extract the string content and trim it
                    String literal = argsContent.substring(i + 1, nextTildeIndex).trim();
                    argsList.add(literal);
                    i = nextTildeIndex + 1; // Move past the closing tilde
                } else {
                    // Mismatched tilde, just treat the rest as a single argument
                    argsList.add(argsContent.substring(i + 1).trim());
                    break;
                }
            } else if (Character.isWhitespace(currentChar) || currentChar == ',') {
                i++; // Skip whitespace and commas
            } else {
                // Handle non-string literal arguments
                StringBuilder currentArg = new StringBuilder();
                while (i < argsContent.length() && argsContent.charAt(i) != ' ' && argsContent.charAt(i) != ',' && argsContent.charAt(i) != '~') {
                    currentArg.append(argsContent.charAt(i));
                    i++;
                }
                if (currentArg.length() > 0) {
                    argsList.add(currentArg.toString());
                }
            }
        }

        return argsList.toArray(new String[0]);
    }

    public static void HEAR_YE(String[] input){
        for(int i = 0; i < input.length; i++){
            System.out.print(input[i] + " ");
        }
    }

    public static String removeComments(String input) {
        Pattern pattern = Pattern.compile("shhh.*?shhh", Pattern.DOTALL);
        Matcher matcher = pattern.matcher(input);
        return matcher.replaceAll("");
    }

}