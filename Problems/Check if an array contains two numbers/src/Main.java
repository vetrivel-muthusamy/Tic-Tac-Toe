import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        boolean res = false;
        int size = 0;

        size = scanner.nextInt();
        int[] array = new int[size];
        for(int i = 0; i < size; i++){
            array[i] = scanner.nextInt();
        }
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        for(int j = 1; j < size; j++){
            if(array[j] == n && array[j-1] == m || array[j] == m && array[j-1] == n){
                res = true;
                break;
            }

        }
        System.out.println(res);
    }
}