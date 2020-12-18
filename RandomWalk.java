public class RandomWalk {
     public static void main(String[] args){
          int[] x = new int[101];
          int[] y = new int[101];

          x[0] = 0;
          y[0] = 0;

          for (int i = 1; i <= 100; i++){
               int d = (int) (Math.random() * 4 + 1);
               if (d == 1){
                    x[i] = x[i - 1];
                    y[i] = y[i - 1] + 1;
               }
               else if (d == 2){
                    y[i] = y[i - 1];
                    x[i] = x[i - 1] - 1;
               }
               else if (d == 3){
                    x[i] = x[i - 1];
                    y[i] = y[i - 1] - 1;
               }
               else{
                    y[i] = y[i - 1];
                    x[i] = x[i - 1] + 1;
               }
          }

          Tools.println("Ending location: (" + x[100] + ", " + y[100] + ")");
     }
}
