import java.util.Scanner;

/**
 * Examples and notes on conditions (Chapter 5)
 *
 * @author Vivek Ily
 * @version November 20th, 2020
 */
public class Conditions {
     public static void ifExample() {
          //model a coin flip; 1: heads, 0: tails
          int coinFlip = (int) (Math.random() * 2);

          /*

          if statement
               Statements are executed if the conditional expression is true.

               Conditional expressions evalueate to either true of false.
               The conditional expression must go inside of parentheses.
               Statements are grouped by blocks (i.e., { }), not by indentation like in Python.
               There is no colon after the conditional expression, unlike Python.

           */

          if (coinFlip == 1) {
               Tools.println("Coin is heads!");
          }

          /*

          if-else statement
               The else block is executed if the condition evaluates to false.

           */

          if (coinFlip == 1) {
               Tools.println("Coin is heads!");
          } else {
               Tools.println("Coin is tails!");
          }

          //model the roll of a four-sided die [1-4]
          int dieRoll = (int) (Math.random() * 4) + 1;

          /*

          if-else statement
               In Java,  "else if" is used instead of "elif" like Python.

           */

          if (dieRoll == 1) {
               Tools.println("Rolled a one");
          } else if (dieRoll == 2) {
               Tools.println("Rolled a two");
          } else if (dieRoll == 3) {
               Tools.println("Rolled a three");
          } else {
               Tools.println("Rolled a four");
          }

          /*

          { } are not required, but it is a good idea to use them always to avoid bugs like this:

           */
          if (coinFlip == 0)
               Tools.println("Coin is tails!");
          Tools.println("Better luck next time...");

     }

     public static boolean doublesAreEqual(double num1, double num2) {
          /*

          If we use the equality operator (==) for doubles, it will only return true if all binary digits match.
          For "equal" numbers, this is probably not the case due to floating-point rounding and, therefore, not what we want.
          We will check if they are "close enough" (i.e., epsilon value).

           */

          final double EPSILON = 1e-14;

          if (Math.abs(num1 - num2) < EPSILON) {
               return true;
          }

          return false;

          //don't have to use an if statement here
          //return Math.abs(num1 - num2) < EPSILON
     }

     public static void stringExample() {
          Scanner scan = new Scanner(System.in);
          Tools.print("Enter two words: ");
          String str1 = scan.next();
          String str2 = scan.next();

          /*

          The equality operator (==) returns true if the two variables (e.g., str1 and str2) contain the same value.
          For variables of a class type, including Strings, this means they contain the same reference. That is, they refer to the same object in memory, not that two Strings have the same sequence of characters.

           */
          if (str1 == str2) {
               Tools.println("String references are equal");
          } else {
               Tools.println("String references are not equal");
          }

          /*

          The equals method returns true if the two objects referenced by the variables are "equal".
               What equals means is defined by the class.

          For Strings, it means that the two objects have the same sequence of characters.

           */

          if (str1.equals(str2)) {
               Tools.println("Strings are equal");
          } else {
               Tools.println("Strings are not equal");
          }

          /*

          We will determine with string comes first lexicographically using the compareTo method of the String class.

          compareTo returns an int:
               0:        if the strings are equal (same sequence of characters)
               <0:       if str1 <  str2 lexicographically
               >0:       if str1 > str2 lexicographically

           */

          int result = str1.compareTo(str2);
          String firstStr = null;

          if (result < 0) {
               firstStr = str1;
          } else if (result > 0) {
               firstStr = str2;
          }

          if (firstStr != null) {
               Tools.println("The first string is: " + firstStr);
               Tools.println("Its length is: " + firstStr.length());
          } else {
               Tools.println("Strings are equal");
          }

          /*

          This is an example of a "short circuit".

          For an AND operation, if the left operand is false, the right operand will not be evaluated because the AND operation is false regardless.

           */
          if (firstStr != null && firstStr.length() > 3) {
               Tools.println("The first string has more than 3 characters.");
          }

          /*

          This is another "short circuit" example.

          For an OR operation, if the left operand is true, the right operand will not be evaluated because the OR operation is true regardless.

          This may result in a bug. If ht efirst word is "kiwi", we will never read the second word from the stream, which may result in unexpected behaviour.
           */
          Tools.print("Enter your two favorite fruits: ");
          if (scan.next().equals("kiwi") || scan.next().equals("kiwi")) {
               Tools.println("Kiwi is one of my favorites too!");
          }

          Tools.print("Enter your favorite ice cream flavor: ");
          String flavor = scan.next();
          Tools.println("Your favorite ice cream flavor is: " + flavor);
     }

     public static void extraOperatorsExample() {
          /*

          augmented assignment operators: +=, -=, *=, /=, %=

               These are the same as in Python.
               Perform the specified mathematical operation to the variable and then assign the resulting value to the same variable.

           */

          int x = 7;
          int y = 7;
          int z = 7;

          x = x + 1;
          y += 1;
          z++;

          /*

          post increment/decrement operators (++/--)

               These are equivalent to adding/subtracting 1 to/from the variable
               These return the avlue before performing the increment/decrement.
           */

          int a = 7;
          int b = a++;

          a--; //decrement as well!
     }

     public static void whileExample() {
          /*

          while loop:

          evaluates boolean expression
               if true, executes the body of the loop and then re-evaluates the condition
               if false, skips the body and continues
           */

          int count = 1;                     // initialization

          while (count <= 5) {                // condition
               Tools.println(count);         // body

               count++;                      // update the loop variable
          }

          Tools.println("Done.");
     }

     public static void whileExample2() {
          /*

          This is an infinite loop!

          A better condition would be:
               while(count < 50)
           */
          int count = 1;
          while (count != 50) {
               Tools.println(count);
               count += 2;
          }

          Tools.println("Done.");
     }

     public static void forExample() {
          /*

          for loop:

               Three parts of the for loop statement:
                    1. initialization - executed once
                    2. condition - boolean expression evaluated at the *start* of each iteration
                    3. update the loop variable - executed at the *end* of each iteration *before* evaluating the condition again
           */

          for (int count = 1; count <= 5; count++) {
               Tools.println(count);
          }

          Tools.println("Complete.");

          /*

          Variables declared witht he for statement are scoped to the for statement and its body
           */
          //Tools.println("Final value of count: " + count);
     }

     public static void forExample2() {
          int count = 1;
          for (; count <= 5; count++) {
               Tools.println(count);
          }

          Tools.println("Complete.");

          Tools.println("Final value of count: " + count);
     }

     public static void offByOne() {
          // We want to print five "*"

          /*

          The infamous off-by-one error is common with for loops executing one too many or one too few times.

          Carefully ask:
               1. Should the initial value start at 0 or 1?    (usually we start at 0 when counting a set number)
               2. Should the condition operator be < or <=?    (usually we use < when counting a set number)

          "Think! Don't compile and try at random!"
           */

          for (int i = 0; i <= 5; i++) { // should be i < 5
               Tools.print("* ");
          }

          Tools.print("\n1 2 3 4 5");
     }

     public static void doExample() {
          /*

          do loop (do-while loop)

               1. executes the body of the loop
               2. evaluates the condition
                    if true, executes the body of the loop again
                    if false, continues execution after the loop
           */

          int count = 1;

          do {
               Tools.println(count);         // body
               count++;                      // update the loop variable
          }
          while (count <= 5);

          Tools.println("Complete.");
     }

     public static int sum() {
          Scanner s = new Scanner(System.in);

          int sum = 0;
          int value;

          do {
               Tools.print("Enter a positive integer (-1 to quit): ");

               /*

               Sentinel Value
                    Value (e.g., -1) used to terminate a loop. It is often entered by a user.
                */

               /*

               The hasNextInt method of the Scanner class returns true if the next token to be read is an integer. Else, it returns false. It does not consume the token. If there are no tokens in the stream, it waits until there are.

                */
               if (s.hasNextInt()) {
                    Tools.println("\"" + s.next() + "\" is not an integer. Try again.");

                    /*

                    continue
                         1. immediately skips to the end of the inner-most loop.
                         2. re-evaluates the loop condition at that point and continues if the condition is true.

                     */
               }
               value = s.nextInt();

               if (value == -1) {
                    /*

                    break
                         Immediately exits the inner-most loop. Similar behaviour as in switch statements.

                     */
                    break;
               }
               // this is a bug! sum is 1 less than it should be.
               sum += value;
          }
          while (value != -1);

          return sum;
     }

     public static void main(String[] args) {
          Tools.print(Tools.isPrime(6));
     }
}
