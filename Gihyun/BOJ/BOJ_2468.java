//실버1 | 안전 영역 | 2468
package Gihyun.BOJ;

import java.io.*;
import java.util.*;

public class BOJ_2468 {
	static int area [][];
	static boolean check [][];
	static int height;
	static int N;
	static int dx [] = {-1,1,0,0};
	static int dy [] = {0,0,-1,1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		area = new int[N][N];
		
		for(int i=0;i<N;i++) {
			String input [] = br.readLine().split(" ");
			for(int j=0;j<N;j++) {
				area[i][j] = Integer.parseInt(input[j]);
			}
		}
		
		ArrayList<Integer> ar = new ArrayList<Integer>(100);
		for(height=0;height<=100;height++) { // height=0 비가 오지 않는 경우 빼서 틀림
			check = new boolean[N][N];
			int count = 0;
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					if(area[i][j]>height&&!check[i][j]) {
						bfs(i,j);
						count++;
					}
				}
			}
			ar.add(count);
		}
		System.out.print(Collections.max(ar));
	}
	static void bfs(int x, int y) {
		Queue<int[]> q = new LinkedList<>();
		check[x][y] = true;
		q.offer(new int[]{x,y});
		
		while(!q.isEmpty()) {
			int out [] = q.poll();
			for(int i=0;i<4;i++) {
				int nx = out[0]+dx[i];
				int ny = out[1]+dy[i];
				
				if(nx>=0&&nx<N&&ny>=0&&ny<N&&!check[nx][ny]&&area[nx][ny]>height) {
					q.offer(new int[]{nx,ny});
					check[nx][ny] = true;
				}
			}
		}
	}

}