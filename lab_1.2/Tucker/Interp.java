import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//Interpreter for DRAMAQUEEN language
public class Interp {
    // Make the Scanner a static field so it's shared across the class
    private static Scanner sharedScanner = new Scanner(System.in);

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
        // Close the scanner only when the program is done
        sharedScanner.close();
    }

    public static void interactiveMode() {
        System.out.println("DRAMAQUEEN v1.0.0");
        StringBuilder commandBuilder = new StringBuilder();
        while (true) {
            System.out.print("~~");
            String line = sharedScanner.nextLine();

            // Check for "shhh" to see if a multi-line command is starting
            if (line.trim().startsWith("shhh") && !line.trim().endsWith("shhh")) {
                commandBuilder.append(line).append("\n");
                System.out.println("... (multi-line comment)");
                while (true) {
                    System.out.print("~-");
                    String continuedLine = sharedScanner.nextLine();
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

    public static void parseAndExecute(String line) {
        String cleanedLine = removeComments(line).trim();
        if (cleanedLine.isEmpty()) {
            return;
        }

        String[] cmd = cleanedLine.split("\\s+");
        // Parse commands with arguments
        for (int i = 0; i < cmd.length; i++) {
            if (cmd[i].contains("HEAR_YE(")) {
                String[] funargs = parseArgs(Arrays.copyOfRange(cmd, i, cmd.length));
                HEAR_YE(funargs);
                System.out.println();
                return;
            } else if (cmd[i].contains("REVERTERE(")) {
                String[] funargs = parseArgs(Arrays.copyOfRange(cmd, i, cmd.length));
                if (funargs.length > 0) {
                    System.out.println(REVERTERE(funargs[0]));
                }
                return;
            }
        }
    }

    public static String[] parseArgs(String[] cmd) {
        String fullCommand = String.join(" ", cmd);
        int openParenIndex = fullCommand.indexOf('(');
        int closeParenIndex = fullCommand.lastIndexOf(')');

        if (openParenIndex == -1 || closeParenIndex <= openParenIndex) {
            return new String[0];
        }

        String argsContent = fullCommand.substring(openParenIndex + 1, closeParenIndex).trim();
        
        // This regex correctly captures the content inside the delimiters
        Pattern stringLiteralPattern = Pattern.compile("~([A-Z]*)\\s(.*?)\\s~\\1");
        Matcher literalMatcher = stringLiteralPattern.matcher(argsContent);
        List<String> literals = new ArrayList<>();
        int literalCounter = 0;
        
        StringBuffer buffer = new StringBuffer();
        while (literalMatcher.find()) {
            literals.add(literalMatcher.group(2));
            literalMatcher.appendReplacement(buffer, "__LITERAL" + literalCounter + "__");
            literalCounter++;
        }
        literalMatcher.appendTail(buffer);
        argsContent = buffer.toString();

        while (argsContent.contains("REVERTERE(") || argsContent.contains("GIVE_ME")) {
            if (argsContent.contains("GIVE_ME")) {
                String userInput = GIVE_ME();
                argsContent = argsContent.replaceFirst("GIVE_ME", "__GIVE_ME_PLACEHOLDER__");
                literals.add(userInput);
            }

            if (argsContent.contains("REVERTERE(")) {
                int revertereStart = argsContent.lastIndexOf("REVERTERE(");
                int argStart = revertereStart + "REVERTERE(".length();
                int parenCount = 1;
                int argEnd = -1;
                for (int i = argStart; i < argsContent.length(); i++) {
                    if (argsContent.charAt(i) == '(') {
                        parenCount++;
                    } else if (argsContent.charAt(i) == ')') {
                        parenCount--;
                        if (parenCount == 0) {
                            argEnd = i;
                            break;
                        }
                    }
                }

                if (argEnd != -1) {
                    String revertereArg = argsContent.substring(argStart, argEnd);
                    String contentToReverse;

                    if (revertereArg.startsWith("__LITERAL")) {
                        int literalIndex = Integer.parseInt(revertereArg.substring("__LITERAL".length(), revertereArg.length() - 2));
                        contentToReverse = literals.get(literalIndex);
                    } else if (revertereArg.equals("__GIVE_ME_PLACEHOLDER__")) {
                        contentToReverse = literals.get(literals.size() - 1); // Get the last GIVE_ME value
                    } else {
                        contentToReverse = revertereArg; // Case for nested function calls or simple arguments
                    }

                    String reversed = REVERTERE(contentToReverse);
                    String replacement = "__LITERAL" + literals.size() + "__";
                    literals.add(reversed);
                    argsContent = argsContent.substring(0, revertereStart) + replacement + argsContent.substring(argEnd + 1);
                }
            }
        }

        if (argsContent.isEmpty()) {
            return new String[0];
        }

        List<String> argsList = new ArrayList<>();
        Pattern argPattern = Pattern.compile("__LITERAL\\d+__|__GIVE_ME_PLACEHOLDER__|[^,]+");
        Matcher argMatcher = argPattern.matcher(argsContent);

        while(argMatcher.find()) {
            String arg = argMatcher.group().trim();
            if (arg.isEmpty()) continue;

            if (arg.startsWith("__LITERAL")) {
                int literalIndex = Integer.parseInt(arg.substring("__LITERAL".length(), arg.length() - 2));
                argsList.add(literals.get(literalIndex));
            } else if (arg.equals("__GIVE_ME_PLACEHOLDER__")) {
                argsList.add(literals.get(literals.size() - 1));
            } else {
                argsList.add(arg);
            }
        }
        
        return argsList.toArray(new String[0]);
    }
    
    public static void HEAR_YE(String[] input){
        for(int i = 0; i < input.length; i++){
            System.out.print(input[i]);
            if(i < input.length - 1) {
                System.out.print(" ");
            }
        }
    }

    public static String removeComments(String input) {
        Pattern pattern = Pattern.compile("shhh.*?shhh", Pattern.DOTALL);
        Matcher matcher = pattern.matcher(input);
        return matcher.replaceAll("");
    }

    public static String GIVE_ME() {
        return sharedScanner.nextLine().trim();
    }
    
    public static String REVERTERE(String input){
        StringBuilder reversed = new StringBuilder(input);
        return reversed.reverse().toString();
    }
}