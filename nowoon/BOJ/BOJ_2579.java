import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2579 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());// 계단 몇칸인가
        int[] floor = new int[n + 1];             // 계단 점수 저장
        int[] score = new int[n + 1];// DP배열

        for (int i = 1; i <= n; i++) {
            floor[i] = Integer.parseInt(br.readLine());
        }

        score[1] = floor[1];
        if (n >= 2) score[2] = floor[1] + floor[2];

        for (int i = 3; i <= n; i++) {
            score[i] = Math.max(score[i - 2] + floor[i], score[i - 3] + floor[i - 1] + floor[i]);
        }

        System.out.println(score[n]);
    }
}
