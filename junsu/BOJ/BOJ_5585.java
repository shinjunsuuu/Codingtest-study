package junsu.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_5585 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int input_money = 1000 - Integer.parseInt(br.readLine());
        int ans = 0;

        int[] coins = {500,100,50,10,5,1};

        for(int coin:coins){
            ans += input_money/coin;
            input_money %= coin;
        }
        System.out.println(ans);
    }
}
