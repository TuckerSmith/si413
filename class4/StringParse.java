import java.util.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.*;

public class StringParse {
    public static void main(String[] args) {
        parseStringsInJavaFile("Example.java");
    }

    public static void parseStringsInJavaFile(String filename) {
        Scanner std = new Scanner(filename);

        while (std.hasNextLine()) {
            String line = std.nextLine();
            System.out.format("line: |%s|\n", line);
            StringBuilder sb = new StringBuilder();
            boolean inLiteral = false;
            for (int i = 0; i < line.length(); i++) {
                char c = line.charAt(i);
                if(c == '"') inLiteral = !inLiteral;
                if(inLiteral) sb.append(c);
            }
            System.out.println(sb.toString());
        }
    }
}
