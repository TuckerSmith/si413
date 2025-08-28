import java.util.*;
import java.io.*;

//Interpreter for DRAMAQUEEN language
public class Interp {
    public static void main(String[] args) {
        if(args.length == 0){
            interactiveMode();
        }
    }

    public static void interactiveMode(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("DRAMAQUEEN v1.0.0");
        while(true){
            System.out.print("~~");
            String[] cmd = scanner.nextLine().split("\\s+");
            
            //parse input
            for(int i = 0; i < cmd.length; i++){
                if (cmd[i].contains("HEARYE(")) {
                    String[] funargs = parseArgs(Arrays.copyOfRange(cmd, i, cmd.length));
                    HEARYE(funargs);
                }
            }
            System.out.println();
            if(cmd[0].equals("quit")) break;
        }

        scanner.close();
    }

    public static String[] parseArgs(String[] cmd){
        // parse the arguments between the parentheses in CMD(arg1, arg2). needs to work for any command
        String[] subcmd = {cmd[0].substring(cmd[0].indexOf("(") + 1)};

        // <1 args or only one argument (e.g., HEARYE(hello))
        if (cmd.length == 1 || subcmd[0].endsWith(")")) {
            // Remove trailing ')' if present
            String arg = subcmd[0];
            if (arg.endsWith(")")) {
                arg = arg.substring(0, arg.length() - 1);
            }
            return new String[]{arg};
        }

        int i = 0;
        while (i + 1 < cmd.length && !cmd[i + 1].endsWith(")")) {
            i++;
            subcmd = Arrays.copyOf(subcmd, subcmd.length + 1);
            subcmd[subcmd.length - 1] = cmd[i];
        }
        if (i + 1 < cmd.length) {
            i++;
            subcmd = Arrays.copyOf(subcmd, subcmd.length + 1);
            subcmd[subcmd.length - 1] = cmd[i].substring(0, cmd[i].length() - 1);
        }
        return subcmd;
    }

    public static void HEARYE(String[] input){
        for(int i = 0; i < input.length; i++){
            System.out.print(input[i] + " ");
        }
    }



}