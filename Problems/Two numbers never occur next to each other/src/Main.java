import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        int [] array = new int[size];
        int n;
        int m;

        boolean yes = true;
        for(int i = 0; i < size; i++){
            array[i] = scanner.nextInt();
        }
        n = scanner.nextInt();
        m = scanner.nextInt();

        // System.out.println(Arrays.toString(array));
        for(int j = 1; j<array.length; j++){
            if ((array[j] == n && array[j-1] == m ) || (array[j] == m && array[j-1] == n)){
                yes = false;
                break;
            }
        }
        System.out.println(yes);
    }
}