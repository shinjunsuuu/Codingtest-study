import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_11726 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] box = new int[n + 1];

        if (n == 1) {
            System.out.println(1);
        } else if (n == 2) {
            System.out.println(2);
        } else {
            box[1] = 1;
            box[2] = 2;

            for (int i = 3; i <= n; i++) {
                box[i] = (box[i - 1] + box[i - 2]) % 10007;
            }

            System.out.println(box[n]);
        }
    }
}
