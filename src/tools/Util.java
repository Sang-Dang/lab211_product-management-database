package tools;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;



/**
 *
 * @author User
 */
public class Util {
    private Util() {}
    
    public static String[] readLinesFromFile(String path) {
        String[] result;
        try {
            BufferedReader input = new BufferedReader(new FileReader(path));
            result = (String[])input.lines().toArray();
            input.close();
        } catch(IOException e) {
            System.out.println(e);
            return null;
        }
        return result;
    }
    
    public static boolean saveLinesToFile(String path, String[] data) {
        try {
            PrintWriter output = new PrintWriter(path);
            for(String i: data) {
                output.println(i);
            }
            output.close();
            return true;
        } catch(IOException e) {
            System.out.println(e);
            return false;
        }
    }
}
