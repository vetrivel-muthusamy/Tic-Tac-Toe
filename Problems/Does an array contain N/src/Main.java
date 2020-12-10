import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        int[] array = new int[size];
        String res = "";
        for (int i = 0; i < size; i++) {
            array[i] = scanner.nextInt();

        }
        //   System.out.println(Arrays.toString(array));
        int n = scanner.nextInt();
        for (int el : array) {
            if (el == n) {
                res = "true";
                break;
            } else {
                res = "false";
            }
        }
        System.out.println(res);
    }
}