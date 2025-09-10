import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2748 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        long[] box = new long[n + 1];
        box[0]=0;
        if (n == 1) {
            System.out.println(1);
        } else {
            box[1] = 1;
            for (int i = 2; i <= n; i++) {
                box[i] = (box[i - 1] + box[i - 2]);
            }

            System.out.println(box[n]);
        }
    }
}
