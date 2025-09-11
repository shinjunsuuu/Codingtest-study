import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1890 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int size = Integer.parseInt(br.readLine());
        int[][] map = new int[n][n];

        for (int x = 0; x < size; x++) {
            String[] str = br.readLine().split(" ");
            for (int y = 0; y < size; y++) {
                map[x][y] = Integer.parseInt(str[y]);
            }
        }

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
