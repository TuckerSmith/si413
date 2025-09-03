import java.util.*;
import java.io.*;
import java.lang.StringBuilder;

public class Interp{
    
    public static boolean hasCommand(String exp, String cmd, int parser){
        
        boolean lengthMatched = exp.length() >= parser + cmd.length();
        return lengthMatched && exp.substring(parser, parser+cmd.length()).equals(cmd);
    }
    
    public static String parseExpression(String exp) throws Exception{
        
        int parser = 0;
        String res = "";

        Boolean unify = false;
        while(parser < exp.length()){
          
            // Reversing
            if(hasCommand(exp, "REVERTERE", parser)){
                
                // Find end of expression for reverse
                parser += 9;
                int eolIndex = exp.substring(parser).lastIndexOf(")");
                
                // Get expression
                String _res = exp.substring(parser, eolIndex+parser);
                
                // Recursively parse expression
                String revres = parseExpression(_res);

                // Reverse string
                StringBuilder sb = new StringBuilder(revres);
                res += sb.reverse().toString();
                parser += eolIndex;
//                System.out.println("sb " + sb);
  //              System.out.println("sbrev" + exp.substring(parser));
            }
            // Take input
            else if(hasCommand(exp, "GIVE_ME", parser)){
                Scanner sc = new Scanner(System.in);
                res += sc.nextLine();
                parser += 7;
            }
            // UNIFY Command. move parser, enable toggle
            else if(hasCommand(exp, "UNIFY", parser)){
                parser += 5;
                unify = true;
            }

            // String literal found
            else if(exp.charAt(parser) == '~'){

                // Find token with ~WORD
                String token = "~" + exp.substring(parser).split(" ")[0].substring(1);

//                System.out.println("explit" + exp.substring(parser));
                parser += token.length() + 1;
               
    //            System.out.println("explit" + exp.substring(parser));
                // Find index of token (end of literal)
                int eolIndex = exp.indexOf(token, parser);

                // Substring line to receive literal value
                String _res = exp.substring(parser, eolIndex - 1);

                // UNIFY operation
                if(unify){
                    res += _res;
                    unify = false;
                }
                else
                    res = _res;
                
                parser = eolIndex + token.length() + 1;
            }
            else{
                parser ++;
            }
        }

        return res;
    }

    public static int getCommentIndex(String line){
        return line.indexOf("shhh");
    }

    public static void main(String[] args) throws IOException{
       
        // Take in file name
        String fname =  args[0];
        Scanner sc = new Scanner(new File(fname));

        Boolean inCommand = false;
        
        // Parse line by line
        while (sc.hasNextLine()){

            // Find ( to find statement
            String line = sc.nextLine().trim();
            int staIndex = line.indexOf("(");
            int commentIndex = getCommentIndex(line); 
            // Check if command continues
            if(inCommand){
                inCommand = getCommentIndex(line) == -1;
            }
            // Check if line has command statement
            else if(commentIndex != -1){
                // Get index of end of comment
                int endIndex = getCommentIndex(line.substring(commentIndex + 4)); 
                
                // If found end of comment, remove comment and continue to parse
                if (endIndex != -1){
                  line = line.substring(0, commentIndex) + line.substring(endIndex + commentIndex + 4);
                }
                // If no end of comment found, enter comment mode
                else{
                  inCommand = true;
                }
              
            }

            // Print statement
            if(hasCommand(line, "HEAR_YE", 0)){
                try{
                  System.out.println(parseExpression(line.substring(staIndex + 1, line.length() - 1)));
                }
                catch(Exception e){
                  System.err.println("Invalid code detected.");
                  System.exit(7);
                }
            }
            
        }

    }
}
