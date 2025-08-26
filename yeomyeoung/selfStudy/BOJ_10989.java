package selfStudy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_10989 {
    public static void main(String[] args) throws Exception{
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int repeat = Integer.parseInt(bufferedReader.readLine());
        int arr[] = new int[repeat];
        int temp;

        for(int i = 0; i < repeat; i++){
            arr[i] = Integer.parseInt(bufferedReader.readLine());
        }

        Arrays.sort(arr);

        StringBuilder stringBuilder = new StringBuilder();
        for(int i : arr){
            stringBuilder.append(i).append("\n");
        }

        System.out.println(stringBuilder);

//        for(int i = 0; i < repeat; i++){
//            for (int k = 0; k < i; k++){
//                if (arr[i] < arr[k]){
//                    temp = arr[i];
//                    arr[i] = arr[k];
//                    arr[k] = temp;
//                }
//            }
//        }
//
    }
}
