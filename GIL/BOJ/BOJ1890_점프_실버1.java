package GIL.BOJ;

import java.io.*;
import java.util.*;

public class BOJ1890_점프_실버1 {

	static int N;
	static int[][] map;
	static long[][] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		map = new int[N][N];
		dp = new long[N][N];

		for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
		
		dp[0][0] = 1;
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if((dp[i][j] == 0)) {
					continue;
				}
				if(i == N - 1 && j == N - 1) {
					continue;
				}
				
				int jump = map[i][j];
				
				int nextI = i + jump;
				if(nextI < N) {
					dp[nextI][j] += dp[i][j];
				}
				
				int nextJ = j + jump;
				if(nextJ < N) {
					dp[i][nextJ] += dp[i][j];
				}
				
			}
		}
		br.close();
		System.out.println(dp[N-1][N-1]);
	}

}
