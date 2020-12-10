import java.util.*;

public class Main {
    public static void main(String[] args) {
        // write your code here
        Scanner sc = new Scanner(System.in);

        char[][] matrix = new char[4][4];

        for (int i = 0; i < 4; i++) {
            matrix[i] = sc.next().toCharArray();
        }

        boolean isPretty = true;
        //boolean stopped = false;
        //rewritten with "return" by myself:
        for (int i = 0; i < 3; i++) {
            //for (int i = 0; i < 3 && !stopped; i++) {
                for (int j = 0; j < 3; j++) {
                    if (matrix[i][j] == matrix[i][j + 1] && matrix[i][j] == matrix[i + 1][j] && matrix[i + 1][j] == matrix[i + 1][j + 1]) {
                        //System.out.print(matrix[i][j] +" "+ matrix[i][j+1]  +" "+  matrix[i+1][j]  +" "+  matrix[i+1][j+1]);
                        System.out.println("NO");
                        isPretty = false;
                        //stopped = true;
                        //break;
                        //The return statement exits from the current method, and control flow returns to where the method was invoked:
                    return;
                }
            }
        }
        System.out.println("YES");
    }
}