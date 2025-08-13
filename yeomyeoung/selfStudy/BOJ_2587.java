package selfStudy;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_2587 {
    public static void main(String[] args) {
        int[] arr = new int[5];
        int sum = 0;
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < 5; i ++ ){
            arr[i] = scanner.nextInt();
            sum += arr[i];
//            scanner.nextLine();
        }
        scanner.close();

        //이거때문에 틀렸었음.
        //단순히 배열의 세 번째 수를 뽑으면
        //순서대로 안 들어왔을 때 중앙값 추출 불가
        Arrays.sort(arr);

        System.out.println(sum / 5);
        System.out.println(arr[2]);

    }
}
