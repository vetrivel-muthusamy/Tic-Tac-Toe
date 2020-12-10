import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        boolean res = false;
        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();
//       System.out.println(string);
        String delims = "[ ]+";
        String[] array = string.split(delims);

        for (int i = 1; i < array.length; i++) {
            //   System.out.println(array[i]);

            int min = array[i].length() > array[i - 1].length() ? array[i - 1].length() : array[i].length();
            for (int j = 0; j < min; j++) {


                res = array[i].charAt(j) >= array[i - 1].charAt(j) && array[i - 1].length()<=min;

            }

        }
        System.out.println(res);
    }
}