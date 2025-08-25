import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_11047 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        String[] a = str.split(" ");
        int coin = Integer.parseInt(a[0]);
        int money = Integer.parseInt(a[1]);
        int count = 0;

        int[] list = new int[coin];
        for (int i = 0; i < coin; i++) { 
            list[i] = Integer.parseInt(br.readLine());
        }

        // 큰 동전부터 나누기
        for (int i = coin - 1; i >= 0; i--) {
            if (list[i] <= money) {
                count += money / list[i];
                money %= list[i];
            }
        }

        System.out.println(count);
    }
}
