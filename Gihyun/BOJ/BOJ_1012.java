// 실버2 | 유기농 배추 | 1012
package Gihyun.BOJ;

import java.io.*;
import java.util.*;

public class BOJ_1012 {
	static int map [][];
	static boolean check [][];
	static int dx [] = {-1, 1, 0, 0};
	static int dy [] = {0, 0, -1, 1};
	static int N,M;

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		ArrayList<Integer> result = new ArrayList<Integer>(T);
		
		for(int i=0;i<T;i++) {
			int count = 0;
			String input [] = br.readLine().split(" ");
			 M = Integer.parseInt(input[0]);
			 N = Integer.parseInt(input[1]);
			int K = Integer.parseInt(input[2]);
			
			map = new int [N][M];
			check = new boolean [N][M];
			
			for(int j=0;j<K;j++) {
				String lettuce [] = br.readLine().split(" ");
				map[Integer.parseInt(lettuce[1])][Integer.parseInt(lettuce[0])] = 1;
			}
			
			for(int l=0;l<N;l++) {
				for(int n=0;n<M;n++) {
					if(map[l][n]==1&&!check[l][n]) {
						bfs(l,n);
						count++;
					}
				}
			}
			result.add(count);
		}
		for(int i : result) {
			System.out.println(i);
		}
	}
	static void bfs(int y, int x) {
		check[y][x] = true;
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {y,x});
		
		while(!q.isEmpty()) {
			int index [] = q.poll();
			for(int i=0;i<4;i++) {
				int ny = index[0] + dy[i];
				int nx = index[1] + dx[i];
				
				if(ny>=0&&ny<N&&nx>=0&&nx<M&&!check[ny][nx]&&map[ny][nx]==1) {
					check[ny][nx] = true;
					q.offer(new int[] {ny,nx});
				}
			}
		}
	}
}