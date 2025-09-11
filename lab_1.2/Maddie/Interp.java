//Madeleine Iverson (263042)
//Lab 1.2
//Chosen language = DRAMAQUEEN


import java.util.*;
import java.io.*;
import java.lang.*;
import java.io.Reader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
import java.util.regex.Pattern;


public class Interp {


   //main method
   public static void main(String[] args) throws IOException {
       //read in file name from command-line argument
       String fname = args[0];


       //make scanner to read in code from file
       Scanner dq = new Scanner(new File(fname));


       while(dq.hasNextLine()){
           //read in full line
           String curLine = dq.nextLine();


           //parse the current line with space as the delineator
           String[] groups = curLine.split(" ");


           //make string to be printed at the end
           String end = "";


           //check to see if it's an empty line
           if(curLine.isEmpty()){
               //discard
               continue;
           }


           //check to see if there's a multi-line comment
           //check if first value is a tab space
           else if(groups[groups.length - 1].equals("shhh")){
               //discard line
               continue;
           }


           //allow for comments
           else if(groups[0].equals("shhh")){
               // discard line
               continue;
           }


           //call specific functions based on what's next
           else {




               //check to see if it's a regular print
               if(groups[0].equals("HEAR_YE(~")){
                   //call print function
                   end = end + print(groups);
               }


               //parse based on parentheses
               groups = curLine.split("\\(|\\)");


               for(int z = 0; z < groups.length; z++){
                   if(groups[z].equals("GIVE_ME")){
                       //make scanner
                       Scanner sc = new Scanner(System.in);


                       end = end + give(sc);
                   }


                   else if(groups[z].equals("REVERTERE")){
                       //call reverse function
                       end = end + reverse(groups[z+1]);
                       z++;
                   }


                   //special case where we want ~ to print
                   // else if(groups[z].equals("HEAR_YE")){
                   //     String sentence = groups[1];


                   //     String[] parsed = sentence.split(" ");


                   //     String marker = parsed[0];
                   //     int j = 1;


                   //     while(!(parsed[j].equals(marker))){
                   //         end = parsed[j] + " ";
                   //         j++;
                   //     }
                   // }


                   //if none of these are entered then there was an error
                   else{
                       //print error statement
                       continue;
                   }
               }  
           }


           //print final string
           if(!end.isEmpty()){
               System.out.println(end);
           }
       }
   }


   //METHOD BELOW


   //print method
   public static String print(String[] groups){
       //get string literal
       String literal = "";
       int i = 1;


       int len = groups.length - 1;


       while(i < len) {


           //check to see if there is a UNIFY
           if(groups[i].equals("~") && groups[i+1].equals("UNIFY")){
               //take away the extra space that is automatically added for generic cases
               String literaltemp = literal.substring(0, literal.length() - 1);


               //check to see if there is a REVERTERE
               //needs some adjustments
               if(groups[i+3].equals("REVERTERE")){
                   literal = unify(literaltemp, reverse(groups[i+3] + " "));
               }


               //concatenate strings
               else {
                   literal = unify(literaltemp, groups[i+3] + " ");
                   i = i + 3;
               }
           }


           //check to see if there is a GIVE_ME
           else if(groups[i].equals("GIVE_ME)")) {
               //make scanner
               Scanner sc = new Scanner(System.in);


               literal = literal + give(sc);
           }


           else {
               //build expression/sentence to be printed out
               literal = literal + groups[i] + " ";
           }


           //increment variable
           i++;
       }


       //delete last space
       String literalfinal = literal.substring(0, literal.length() - 1);


       return literalfinal;
   }


    //give me method
   public static String give(Scanner sc){
       //read in a return string from stdin
       String input = sc.nextLine();
       return input;
   }


   //reverse method
   public static String reverse(String s){
       //see if user input is required
       if(s.equals("GIVE_ME")){
           //make new scanner and read in
           Scanner sc = new Scanner(System.in);
           s = sc.nextLine();
       }
      
       //Get length of input
       int len = s.length();


       String rev = "";


       //print the string in reverse
       for(int j = len-1; j >= 0; j--){
           rev = rev + s.charAt(j);
       }


       return rev;
   }


   //unify method
   public static String unify(String i, String j){
       //check to see if there is a GIVE_ME
       if(j.equals("GIVE_ME) ")) {
           //make scanner
           Scanner sc = new Scanner(System.in);


           j = give(sc);
       }


       String k = i + j + " ";
       return k;
   }
}


 






           // //if starts with HEAR_YE~ then it's printing
           // else if(groups[0].equals("HEAR_YE(~")){
           //     //get string literal
           //     String literal = "";
           //     int i = 1;


           //     while(!(groups[i].equals("~)"))) {


           //         //check to see if there is a UNIFY
           //         if(groups[i].equals("~") && groups[i+1].equals("UNIFY")){
           //             //take away the extra space that is automatically added for generic cases
           //             String literaltemp = literal.substring(0, literal.length() - 1);


           //             //concatenate strings
           //             literal = literaltemp + groups[i+3] + " ";
           //             i = i + 3;
           //         }


           //         else {
           //             //build expression/sentence to be printed out
           //             literal = literal + groups[i] + " ";
           //         }


           //         //increment variable
           //         i++;
           //     }


           //     //delete last space
           //     String literalfinal = literal.substring(0, literal.length() - 1);


           //     System.out.println(literalfinal);
           // }


           // //if it isn't a regular HEAR_ME or shhh, then parse by parentheses to get more info
           // else {
           //     String[] irreg = curLine.split("(");


           //     //any possible expression in this language either starts with HEAR_YE or shhhh
           //     //so the first string in this group should be HEAR_YE, if not, it's an error


           //     String make = "";


           //     for(int i = 0; i < irreg.length; i++) {
           //         if(irreg[i].equals("GIVE_ME") || irreg[i].equals("GIVE_ME)")){
           //             //make new scanner
           //             Scanner sc = new Scanner(System.in);


           //             //read in string from stdin
           //             String input = sc.nextLine();


           //             make = make + input;
           //         }


           //         else if(irreg[i].equals("REVERTERE")) {
           //             //make new scanner
           //             Scanner sc = new Scanner(System.in);


           //             //read in string from stdin
           //             String input = sc.nextLine();


           //             //Get length of input
           //             int len = input.length();


           //             //print the string in reverse
           //             for(int j = len-1; j >= 0; j--){
           //                 make = make + input.charAt(j);
           //             }
           //         }               
           //     }


           // }


           // //allow for string reversal
           // else if(groups[0].equals("HEAR_YE(REVERTERE(GIVE_ME))")){
           //     //make new scanner
           //     Scanner sc = new Scanner(System.in);


           //     //read in string from stdin
           //     String input = sc.nextLine();


           //     //Get length of input
           //     int len = input.length();


           //     //print the string in reverse
           //     for(int i = len-1; i >= 0; i--){
           //         System.out.print(input.charAt(i));
           //     }
           // }


           //special cases (escape sequences)


//         }
     
//     }
// }


   // //method for GIVE_ME
   // public static String give(Scanner sc){


   // }


   //     //check to see if there is a GIVE_ME
   // else if(groups[0].equals("HEAR_YE(GIVE_ME)")) {
   //     //make new scanner
   //     Scanner sc = new Scanner(System.in);


   //     //read in string from stdin
   //     String input = sc.nextLine();


   //     System.out.println(input);
   // }
   // }







