import java.util.*;

public class Main {
    public static void main(String[] args) {
        // write your code here
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        double n = m * m;
        int[][] arr = new int[m * m][m * m];
        boolean crossed = false;
        double sum = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        for (int j = 0; j < n; j++) {
            sum = 0;
            for (int i = 0; i < n; i++) {
                sum = sum + arr[i][j];
            }
            if (sum != n * ((n + 1) / 2))
                crossed = true;
            break;
        }

        for (int i = 0; i < n && !crossed; i++) {
            sum = 0;
            for (int j = 0; j < n; j++) {
                sum = sum + arr[i][j];
            }
            if (sum != n * ((n + 1) / 2))
        crossed = true;
        break;
    }


//        int k = 0;
//        while (k < n) {
//            for (int i = 0; i < n && !crossed; i++) {
//                for (int j = k + 1; j < n; j++) {
//                    if (arr[i][j] == arr[i][k]) {
//                        crossed = true;
//                        break;
//                    }
//                }
//            }
//            k++;
//        }
//        k = 0;
//        while (k < n) {
//            for (int i = k + 1; i < n && !crossed; i++) {
//                for (int j = 0; j < n; j++) {
//                    if (arr[j][i] == arr[j][k]) {
//                        crossed = true;
//                        break;
//                    }
//                }
//            }
//            k++;
//        }

//        wholeloop:
//        for (int k = 0; k <= n; k++) {
//            if (sum != n * ((n + 1) / 2)) {
//                crossed = true;
//                break wholeloop;
//            } else {
//                sum = 0;
//            }
//            for (int i = 0; i < m; i++) {
//                for (int j = 0; j < m; j++) {
//                    sum = sum + arr[i][j];
//                }
//            }
//
//        }
        for (int row = 0; row < n; row += m) {
        for (int col = 0; col < n; col += m) {
            // row, col is start of the 3 by 3 grid
            for (int pos = 0; pos < n - 1; pos++) {
                for (int pos2 = pos + 1; pos2 < n; pos2++) {
                    if (arr[row + pos % m][col + pos / m] == arr[row + pos2 % m][col + pos2 / m]) {
                        crossed = true;
                        break;
                    }
                }
            }
        }
    }

        if (crossed) {
        System.out.println("NO");
    } else
            System.out.println("YES");
    }
}