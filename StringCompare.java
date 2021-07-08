
/**
 * Write a description of class StringCompare here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class StringCompare
{
    public static void main(String[] args){
        String word1 = "catalog";
        String word2 = "cat";

        int result = word1.compareTo("aaa");
        
        if (result > 0){
            System.out.println("condition #1 is true");
        }
        else{
            System.out.println("condition #1 is not true");
        }
        
        int result1 = word1.compareTo(word2);
        
        if (result1 == 0){
            System.out.println("condition #2 is true");
        }
        else{
            System.out.println("condition #2 is not true");
        }
        
        if (result1 < 0){
            System.out.println("condition #3 is true");
        }
        else{
            System.out.println("condition #3 is not true");
        }
        
        String word1_prefix = word1.substring(0,3);
        String word2_prefix = word2.substring(0,3);
        
        if (word1_prefix.compareTo(word2_prefix) == 0){
            System.out.println("condition #4 is true");
        }
        else{
            System.out.println("condition #4 is not true");
        }
    }
}
