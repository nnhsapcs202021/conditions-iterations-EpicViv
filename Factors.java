public class Factors {
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
