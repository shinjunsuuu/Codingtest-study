package selfStudy;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_2751 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int times = scanner.nextInt();
        int[] arr = new int[times];

        for(int i = 0; i < times; i++){
            arr[i] = scanner.nextInt();
        }
        scanner.close();

        Arrays.sort(arr);

        StringBuilder stringBuilder = new StringBuilder();
        for(int a : arr){
            stringBuilder.append(a).append('\n');
        }
        System.out.println(stringBuilder);
    }
}
