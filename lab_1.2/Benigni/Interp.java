import java.util.*;
import java.io.*;


public class Interp{

	public static void main(String[] args){

		// Check for file name
		if(args.length ==0){
			System.err.println("No file provided: java Interp <filename>");
			System.exit(7);
		}

		String fName = args[0];												// Get file name from command-line
		String programLines = scanInProgram(fName);							// Get all lines from the file
		if(programLines == null){											// Check if inputted file was empty
			System.err.println("File is empty");
			System.exit(7);
		}

		// Get rid of comments within program
		String programMinusComments = removeComments(programLines);
		parseProgram(programMinusComments);
		
	}


	// Helper Class to hold both the expression and expression index
	public static class Expression{
		String text;
		int nextIdx;
		Expression(String text, int nextIdx){
			this.text = text;
			this.nextIdx = nextIdx;
		}
	}

	// Reads in the program from inputted file
	public static String scanInProgram(String fName){

		// Try to open the file and read in its contents
		try{

			StringBuilder programText = new StringBuilder();

			File file = new File(fName);									// Open file
			Scanner fileScanner = new Scanner(file);						// Create scanner

			while(fileScanner.hasNextLine()){								// Loop through all lines in the file
				programText.append(fileScanner.nextLine()).append('\n');	// Append lines on to fileText seperated by a new line
			}

			fileScanner.close(); 											// Close scanner after finished reading

			return programText.toString();									// return program

		} catch(FileNotFoundException e){									// If file not found, print out error message and return null
			System.err.println("ERROR: File " + fName + " does not exist");
			return null;
		}
	}

	// Parse through the program and execute its contents
	// Will parse through each character to find calls that are made
	private static void parseProgram(String programText){
		int i = 0;

		while(i < programText.length()){									// Loop through the program character by character
			
			// Skipping any whitespace encountered
			while(i < programText.length() && Character.isWhitespace(programText.charAt(i)))
				i++;

			if(i >= programText.length())										// Exit once end of program is reached
				break;

			if(programText.startsWith("HEAR_YE(", i)){							// Checks if program starts with 'HEAR_YE(' from the given index i
				i += "HEAR_YE(".length();
				Expression expression = determineExpression(programText, i);	// Gets the expression from within the HEAR_YE()
				i = expression.nextIdx;											// Moves i to the character after the expression

				// Check for closing parentheses
				if(i >= programText.length() || programText.charAt(i) != ')'){
					System.err.println("ERROR: Missing closing ')' for HEAR_YE expression.");
					System.exit(7);
				}
				
				i++;															// Pass the closing ')'

				HEAR_YE(expression.text);										// Print out the statement after determining what it is and evaluating all inner expressions
			}
			

		}

	}

	// Determine whether expression is a String Literal, Reversal, or Input
	// Will recursively iterate through expressions until inner expression is reached
	public static Expression determineExpression(String programText, int exprIdx){
		
		while(exprIdx < programText.length() && Character.isWhitespace(programText.charAt(exprIdx))){	// Skip any whitespace to start the expression
			exprIdx++;
		}

		// expr1 will be returned should no UNIFY operator be found.
		// Should UNIFY be located within a given line, expr1 will be held while expr2 is evaluated.
		// From there expr1 will be concatenated with expr2
		Expression expr1;

		// Determine expression type
		if(programText.startsWith("~", exprIdx)){								// TYPE: string literal
			expr1 = stringLiteral(programText, exprIdx);						// Store the expression value as well as the index from which to continue parsing from
		}
		else if(programText.startsWith("REVERTERE", exprIdx)){					// TYPE: REVERTERE
			
			int expressionStart = exprIdx + "REVERTERE".length();				// Ensure there is an opening parentheses
			if(programText.charAt(expressionStart) != '('){
				System.err.println("ERROR: Missing opening '(' for REVERTERE expression.");
				System.exit(7);
			}

			Expression innerExpression = determineExpression(programText, expressionStart+1);	// Recursive call to get the inner value of the expression within REVERTERE
			String reversedExpression = REVERTERE(innerExpression.text);						// Reverse the returned value of the expression

			// Check for closing parentheses
			if(programText.charAt(innerExpression.nextIdx) != ')'){
				System.err.println("ERROR: Missing closing ')' for REVERTERE expression.");
				System.exit(7);
			}

			expr1 = new Expression(reversedExpression, innerExpression.nextIdx + 1);			// Store the reversed expression as well as the index from which to continue parsing from
		}
		else if(programText.startsWith("GIVE_ME", exprIdx)){					// TYPE: GIVE_ME
			String userInput = GIVE_ME();										// Get the input from the user
			int expressionEndIndex = exprIdx + "GIVE_ME".length();				// Jump to the end of the expression
			expr1 = new Expression(userInput, expressionEndIndex);				// Store the user input as well as the index from which to continue parsing from
		}
		else{
			System.err.println("ERROR: Unknown expression");					// If unknown expression happens
			System.exit(7);
			expr1 = null;														// Simply to prevent not initialized error when expr1 is accessed further down
		}
		
		// Check for UNIFY operator
		while(expr1.nextIdx < programText.length() && Character.isWhitespace(programText.charAt(expr1.nextIdx))){	// Skip any whitespace to start the expression
			expr1.nextIdx++;
		}

		if(programText.startsWith("UNIFY", expr1.nextIdx)){							// Continuing parsing at expr1 index
			int idxOfUNIFY = expr1.nextIdx + "UNIFY".length();						// Get the index of the UNIFY operator
			Expression expr2 = determineExpression(programText, idxOfUNIFY);		// Make recursive call to get expr2's value

			String expr1UNIFYexpr2 = UNIFY(expr1.text, expr2.text);					// UNIFY expr1 and expr2 together
			Expression complete = new Expression(expr1UNIFYexpr2, expr2.nextIdx);	// Store the value of the unified expressions as well as the index from which to contiue parsing form
			return complete;														// return completed expression	
		}

		// Should no UNIFY operator be found, return expr1
		return expr1;
	}

	// Parse through and return the string literal within the expression
	private static Expression stringLiteral(String expression, int idx){

		// Check literal is opened correctly
		if(expression.charAt(idx) != '~' || expression.length() < 4){
			System.err.println("ERROR: literal missing either '~' or does not meet length requirements");
			System.exit(7);
		}

		// Check for a magic word
		int i = idx + 1;
		StringBuilder magicWord = new StringBuilder();

		// Iterate over all capital letters appended to opening '~'
		while(i < expression.length() && Character.isUpperCase(expression.charAt(i))){
			magicWord.append(expression.charAt(i));
			i++;
		}

		// Check for ' ' after magic word
		if(i >= expression.length() || expression.charAt(i) != ' '){
			System.err.println("ERROR: Missing ' ' after magic word: \"" + magicWord.toString() + "\"");
			System.exit(7);
		}
		i++;																// Move past the ' '

		// Find the index of the closing delimeter
		String closingMagicWord = " " + "~" + magicWord.toString();			
		int closingIdx = expression.indexOf(closingMagicWord, i);

		if(closingIdx == -1){												// Check for matching closing delimeter
			System.err.println("ERROR: missing closing delimeter");
			System.exit(7);
		}

		String literal = expression.substring(i, closingIdx);									// Get the contents of the literal
		Expression complete = new Expression(literal, closingIdx + closingMagicWord.length());	// Build new expression with string literal as its value and pass the next index to continue parsing at
		return complete;																		// Return contents of the literal
	}

	private static String removeComments(String programText){
		String commentCather = "(?s)shhh.*?shhh";							// Regular expression to match all paired comments: (?s) is a flag signalling to the '.' to include newlines as well
		programText = programText.replaceAll(commentCather, "");			// Removes paired comments

		int brokenCommentIdx = programText.indexOf("shhh");					// Find any comments without a closing matching "shhh"

		if(brokenCommentIdx >= 0)											// Check if there are any broken comments
			return programText.substring(0,brokenCommentIdx);				// Return the program minus the code that was cutoff due to broken comment
		else
			return programText;												// No broken comment, return program minus all comments
	}

	// Function to print to the screen
	public static void HEAR_YE(String output){
		System.out.println(output);
	}

	// Function to reverse a string literal
	public static String REVERTERE(String regular){
		
		StringBuilder reversedString = new StringBuilder();					// Create StringBuilder object
		reversedString.append(regular);										// Append the string to the StringBuilder object
		reversedString.reverse(); 											// Reverse the string
		return reversedString.toString(); 									// Return the reversed StringBuilder Object as a String
	} 

	// Concatenates two expressions together
	public static String UNIFY(String expr1, String expr2){
		return expr1 + expr2;
	}

	// Reads in user input from the terminal as a string literal
	public static String GIVE_ME(){
		Scanner scanner = new Scanner(System.in);
		String input = scanner.nextLine();									// Read in input
		scanner.close();													// Close scanner to prevent leaks
		return input;														// Return user input
	}
}

