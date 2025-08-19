package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1546 {
    public static void main(String[] args) throws Exception{
        // 입력받는거 너무 더럽나..?
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        StringTokenizer stringTokenizer = new StringTokenizer(bf.readLine());
        int scores = Integer.parseInt(st.nextToken());

        // 연산에 필요한 변수들
        double[] arr = new double[scores];
        double sum = 0.0;

        for(int i = 0; i < scores; i++){
            arr[i] = Integer.parseInt(stringTokenizer.nextToken());
//            System.out.println(arr[i]);
        }
        Arrays.sort(arr);
//        System.out.println(arr[scores - 1]);

        for(int k = 0; k < scores; k++){
            sum += (arr[k] / arr[scores - 1]) * 100;
        }

        System.out.println(sum / (double) scores);

    }
}
