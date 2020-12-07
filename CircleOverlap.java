import java.util.Scanner;

public class CircleOverlap
{
   public static void main(String[] args)
   {
      Scanner in = new Scanner(System.in);

      System.out.print("Input the radius of the first circle: ");
      double radius1 = in.nextDouble(); 
      double xcenter1 = 0;
      double ycenter1 = 0;
      System.out.print("Input the radius of the second circle: ");
      double radius2 = in.nextDouble(); 
      double xcenter2 = 40;
      double ycenter2 = 0;

      double sum = radius1 + radius2;
      
      if (sum < 40){
          System.out.println("Circles are disjoint");
      }
      else if (radius1 > 40 + radius2){
          System.out.println("Circles are mutually contained");
      }
      else if (radius2 > 40 + radius1){
          System.out.println("Circles are mutually contained");
      }
      else{
          System.out.println("Circles are overlapping");
      }
   }
}