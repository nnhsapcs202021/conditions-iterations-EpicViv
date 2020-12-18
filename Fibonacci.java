import java.util.Scanner;

public class Fibonacci {

     private int e1;
     private int e2;
     private int eNew;

     public Fibonacci() {
          this.e1 = 1;
          this.e2 = 1;
          this.eNew = this.e1 + this.e2;
     }

     public static int findN() {
          Scanner scan = new Scanner(System.in);
          Tools.print("Enter an integer n to find the nth term of the Fibonacci sequence: ");
          int n;
          int a;

          int num1 = 1;
          int num2 = 1;

          n = scan.nextInt();
          a = n % 2;

          if (n == 1 || n == 2) {
               return 1;
          } else {
               for (int c = 3; c <= n; c++) {
                    int numNew = num1 + num2;

                    if (c % 2 == 1) {
                         num1 = numNew;
                    } else {
                         num2 = numNew;
                    }
               }
          }

          if (a == 1) {
               return num1;
          } return num2;
     }

}
