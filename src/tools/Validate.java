package tools;

/**
 *
 * @author User
 */
public class Validate {
    private Validate() {}
    
    public static boolean stringNonEmpty(String s) {
        for (int i = 0; i < s.length(); i++) 
            if(s.charAt(i) != ' ')
                return true;
        return false;
    }
    
    public static boolean name(String s) {
        return s.length() >= 5;
    }
    
    public static boolean doubleRange(double d, double lowerBound, double upperBound, boolean inclusive) {
        return inclusive ? d >= lowerBound && d <= upperBound : d > lowerBound && d < upperBound; 
    } 
    
    public static boolean intRange(int i, int lowerBound, int upperBound, boolean inclusive) {
        return inclusive ? i >= lowerBound && i <= upperBound : i > lowerBound && i < upperBound;
    }
}
