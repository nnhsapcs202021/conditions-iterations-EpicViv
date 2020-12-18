import java.awt.*;

public class Tools {
     public static void help(){
          println("You requested the output of the documentation for the Tools class.");
          println("Beginning output of information..."); enter(); enter();
          println("Type: \t\t\t\t\tMethods in Tools class: "); enter();

          println("void \t\t\t\t\tprint(String str)");
          println("\t\t\t\t\t\t\t\tPrints the inputted String value. ");

          println("void \t\t\t\t\tprintln(String str)");
          println("\t\t\t\t\t\t\t\tPrints the inputted String value. ");

          println("void \t\t\t\t\tprint(int num)");
          println("\t\t\t\t\t\t\t\tPrints the inputted int value. ");

          println("void \t\t\t\t\tprint(int num)");
          println("\t\t\t\t\t\t\t\tPrints the inputted int value. ");

          println("void \t\t\t\t\tprint(double num)");
          println("\t\t\t\t\t\t\t\tPrints the inputted double value. ");

          println("void \t\t\t\t\tprint(double num)");
          println("\t\t\t\t\t\t\t\tPrints the inputted double value. ");

          println("void \t\t\t\t\tprint(Color color)");
          println("\t\t\t\t\t\t\t\tPrints the RGB values of the inputted Color value. ");

          println("void \t\t\t\t\tprint(boolean a)");
          println("\t\t\t\t\t\t\t\tPrints the value of the inputted boolean value. ");

          println("void \t\t\t\t\tenter()");
          println("\t\t\t\t\t\t\t\tMoves cursor focus to next line. ");

          println("void \t\t\t\t\tprint(int[] array)");
          println("\t\t\t\t\t\t\t\tPrints the values in an array of integers. ");

          println("void \t\t\t\t\tprint(double[] array)");
          println("\t\t\t\t\t\t\t\tPrints the values in an array of doubles. ");

          println("void \t\t\t\t\tprint(String[] array)");
          println("\t\t\t\t\t\t\t\tPrints the values in an array of Strings. ");

          println("int[] \t\t\t\t\tadd(int[] a, int b)");
          println("\t\t\t\t\t\t\t\tAdds the integer value b to the end of preexisting integer array a and returns the new integer array. ");

          println("double[] \t\t\t\tadd(double[] a, double b)");
          println("\t\t\t\t\t\t\t\tAdds the double value b to the end of preexisting double array a and returns the new double array. ");

          println("boolean \t\t\t\tisDivisible(int num1, int num2)");
          println("\t\t\t\t\t\t\t\tReturns true if parameter num1 is divisible by parameter num2. ");

          println("boolean \t\t\t\tisPrime(int num)");
          println("\t\t\t\t\t\t\t\tReturns true if the inputted integer is prime. ");

          println("void \t\t\t\t\tprintFactors(int num)");
          println("\t\t\t\t\t\t\t\tPrints the prime factors of the inputted integer. ");

     }

     public static void print(String x) {
          System.out.print(x);
     }

     public static void println(String x) {
          System.out.println(x);
     }

     public static void print(int x) {
          System.out.print(x);
     }

     public static void println(int x) {
          System.out.println(x);
     }

     public static void print(double x) {
          System.out.print(x);
     }

     public static void println(double x) {
          System.out.println(x);
     }

     public static void print(Color col) {
          System.out.println(col);
     }

     public static void print(Boolean bool) {
          System.out.println(bool);
     }

     public static void enter() {
          print("\n");
     }

     public static void print(int[] x) {
          print("{" + x[0]);
          for (int i = 1; i < x.length; i++) {
               print(", " + x[i]);
          }
          print("}");
     }

     public static void print(double[] x) {
          print("{" + x[0]);
          for (int i = 1; i < x.length; i++) {
               print(", " + x[i]);
          }
          print("}");
     }

     public static void print(String[] x) {
          print("{" + x[0]);
          for (int i = 1; i < x.length; i++) {
               print(", " + x[i]);
          }
          print("}");
     }

     public static int[] add(int[] a, int b) {
          int len = a.length;
          int[] newArray = new int[len + 1];
          int newLen = newArray.length;
          for (int i = 0; i < len; i++) {
               newArray[i] = a[i];
          }
          newArray[newLen - 1] = b;
          return newArray;
     }

     public static double[] add(double[] a, double b) {
          int len = a.length;
          double[] newArray = new double[len + 1];
          int newLen = newArray.length;
          for (int i = 0; i < len; i++) {
               newArray[i] = a[i];
          }
          newArray[newLen - 1] = b;
          return newArray;
     }

     public static boolean isDivisible(int num1, int num2){
          boolean flag = false;
          double check = 1.0 * num1 / num2;

          if (check == Math.floor(check)) {
               flag = true;
          }
          return flag;
     }

     public static boolean isPrime(int num) {
          boolean flag = true;
          if (num != 1) {
               for (int i = 2; i < num; i++) {
                    double check = 1.0 * num / i;

                    if (check == Math.floor(check)) {
                         flag = false;
                         break;
                    }
               }
          } else {
               flag = false;
          }
          return flag;
     }

     public static void printFactors(int num){
          if (Tools.isPrime(num)){
               Tools.println("1\n" + num);
          } else {
               int holder = num;

               for (int i = 2; i <= num; i++){
                    if (Tools.isDivisible(holder, i)){
                         Tools.println(i);
                         holder = holder/i;
                         i--;
                    }
               }
          }
     }
}
