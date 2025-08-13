package selfStudy;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_25305 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int repeat = scanner.nextInt();
        int awardCount = scanner.nextInt();
        int[] arr = new int[repeat];

        for(int i = 0; i < repeat; i++){
            arr[i] = scanner.nextInt();
        }
        scanner.close();
        Arrays.sort(arr);
//        System.out.println(arr[0]);

        int cutLine = (repeat - awardCount);
            System.out.println(arr[cutLine]);
        }
}
