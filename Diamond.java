import java.util.Scanner;

/**
 * Write a description of class Diamond here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Diamond {
     public static void main(String[] args) {
          Scanner in = new Scanner(System.in);
          System.out.print("Input A Side Length: ");
          int side = in.nextInt();

          for(int row = 1; row < 2 * side - 1; row++){
               if (row <= 4){
                    for(int i = 3; i >= 0; i--){
                    for(int spaces = 0; spaces < i; spaces++){
                         System.out.print(" ");
                    }}

                    for(int stars = 1; stars < side * 2; stars += 2){
                         System.out.print("*");
                    }
               }
          }
     }
}
