package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_5585 {
    public static void main(String[] args) throws Exception{
        int[] coins = {500, 100, 50, 10, 5, 1};
        int coinCount = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 필요없는거 아는데 연습겸 써봄
        StringTokenizer st = new StringTokenizer(br.readLine());

        int change = (1000 - Integer.parseInt(st.nextToken()));
        int biggestCoinIndex = 0;

        while(change != 0){
            if(coins[biggestCoinIndex] <= change){
                ++coinCount;
                change -= coins[biggestCoinIndex];
            }
            else {
                ++biggestCoinIndex;
            }
        }
        System.out.println(coinCount);
    }
}
