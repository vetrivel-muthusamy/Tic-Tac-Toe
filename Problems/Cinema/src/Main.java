import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        boolean isAvailable = false;
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int array[][] = new int[n][m];
        for(int i=0; i<n; i++){
            for(int j = 0; j < m; j++){
                array[i][j] = scanner.nextInt();

            }
        }
        int k = scanner.nextInt();

        for(int i=0; i<n; i++){
            for(int j = 0; j < m; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }

        //  int freePlaces = 0;
        int row = 0;
        for(int i = 0; i < n; i++){
            int freePlaces = 0;
            if(isAvailable == true){break; }
            for(int j = 0; j < m; j++){
                if(array[i][j] == 0){
                    freePlaces = freePlaces +1;
                    if(freePlaces == k){
                        isAvailable = true;
                        //  System.out.println(row+1);
                        row = i + 1;
                        break;}
                } else {  freePlaces = 0;  }

            }

        }
        System.out.println(row);
    }
}