package BOJ;

import java.util.Scanner;

public class BJ_11720 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int length = scanner.nextInt();
        String str = scanner.next();
        scanner.close();
        int sum = 0;

        String[] arr = str.split("");

        for(int i = 0; i < length; i++){
            sum += Integer.parseInt(arr[i]);
        }

        System.out.println(sum);
    }
}
