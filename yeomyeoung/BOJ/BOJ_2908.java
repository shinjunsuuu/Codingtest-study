package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2908 {
    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int[] arr1 = new int[3];
        int[] arr2 = new int[3];
        int[] digits = {1,10,100};
        int index = 0;
        int firstResult = 0;
        int secondResult = 0;

        int firstNum = Integer.parseInt(st.nextToken());
        int secondNum = Integer.parseInt(st.nextToken());

        for (int i = 2; 0 <= i; i--){
            arr1[i] = firstNum / digits[i];
            firstNum %= digits[i];
            firstResult += arr1[i] * digits[index++];
        }

        index = 0;

        for (int k = 2; 0 <= k; k--){
            arr2[k] = secondNum / digits[k];
            secondNum %= digits[k];
            secondResult += arr2[k] * digits[index++];
        }

        if (secondResult < firstResult){
            System.out.println(firstResult);
        }
        else System.out.println(secondResult);
    }
}
