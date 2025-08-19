package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11047 {
    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int coinType = Integer.parseInt(st.nextToken());
        int targetPrice = Integer.parseInt(st.nextToken());
        int[] coins = new int[coinType];
        int coinCount = 0;

        for(int i = 0; i < coinType; i++){
            coins[i] = Integer.parseInt(bf.readLine());
        }

        for(int k = (coinType - 1); targetPrice != 0; k--){
            if(coins[k] <= targetPrice){
                coinCount++;
                targetPrice -= coins[k];
                k++;
            }
            else continue;
        }

        System.out.println(coinCount);
    }
}
