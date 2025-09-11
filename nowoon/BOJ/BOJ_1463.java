import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1463 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] map = new int[n + 1];

        map[1] = 0; // 1은 이미 1이니까

        for (int i = 2; i <= n; i++) {
            map[i] = map[i - 1] + 1; // 기본적으로 -1 연산
            if (i % 2 == 0) {
                map[i] = Math.min(map[i], map[i / 2] + 1);
            }
            if (i % 3 == 0) {
                map[i] = Math.min(map[i], map[i / 3] + 1);
            }
        }

        System.out.println(map[n]);
    }
}
