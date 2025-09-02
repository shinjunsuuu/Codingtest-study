// 실버1 | 그림 | 1926
package Gihyun.BOJ;

import java.io.*;
import java.util.*;

public class BOJ_1926 {
	static int ground [][];
	static boolean check [][];
	static int dx [] = {-1,1,0,0};
	static int dy [] = {0,0,-1,1};
	static int n,m;

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input [] = br.readLine().split(" ");
		n = Integer.parseInt(input[0]);
		m = Integer.parseInt(input[1]);
		ground = new int [n][m];
		check = new boolean[n][m];
		
		for(int i=0;i<n;i++) {
			String g [] = br.readLine().split(" ");
			for(int j=0;j<m;j++) {
				ground [i][j] = Integer.parseInt(g[j]);
			}
		}
		
		ArrayList<Integer> pic = new ArrayList<Integer>();
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				if(ground[i][j]==1&&!check[i][j]) {
					pic.add(bfs(i,j));
				}
			}
		}
		if(pic.isEmpty()) {
			System.out.print(0+"\n"+0);
		}else {
			System.out.print(pic.size()+"\n"+Collections.max(pic));
		}
	}
	static int bfs(int y, int x) {
		check[y][x] = true;
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[]{y,x});
		int count = 1;
		
		while(!q.isEmpty()) {
			int out [] = q.poll();
			for(int i=0;i<4;i++) {
				int ny = out[0] + dy[i];
				int nx = out[1] + dx[i];
				
				if(ny>=0&&ny<n&&nx>=0&&nx<m&&!check[ny][nx]&&ground[ny][nx]==1) {
					check[ny][nx] = true;
					q.offer(new int[]{ny,nx});
					count++;
				}
			}
		}
		return count;
	}

}