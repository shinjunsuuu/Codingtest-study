package BOJ;

import java.util.Scanner;

public class BOJ_2750 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int repeat = scanner.nextInt();
        int[] arr = new int[repeat];
        for (int i = 0; i < repeat; i++){
            arr[i] = scanner.nextInt();
        }
        scanner.close();

        for (int k = 1; k < repeat; k++){
            for (int j = 0; j < (repeat - k); j ++){
                int temp = 0;
                if(arr[j] > arr[j+1]){
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }

        for (int i = 0; i < repeat; i++){
            System.out.println(arr[i]);
        }


    }
}
