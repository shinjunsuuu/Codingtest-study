package GIL.BOJ;

import java.io.*;
import java.util.*;

public class Solution1012 {

	static int T, M, N, K; // T:테스트케이스 개수, M: 배추밭 가로길이, N: 세로길이, K: 배추가 심어져 있는 위치의 개수
	static int[][] map;
	static boolean[][] visited;
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };
	
	public static void bfs(int startR, int startC) {
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] { startR, startC });
		
		visited[startR][startC] = true;
		
		while(!queue.isEmpty()) {
			int[] current = queue.poll();
			int curR = current[0];
			int curC = current[1];
			
			for(int i = 0; i < 4; i++) {
				int nextR = curR + dr[i];
				int nextC = curC + dc[i];
				
				if(nextR < 0 || nextR >= N || nextC < 0 || nextC >= M) {
					continue;
				}
				if(visited[nextR][nextC]) {
					continue;
				}
				if(map[nextR][nextC] == 0) {
					continue;	
				}
				
				visited[nextR][nextC] = true;
				queue.offer(new int[] {nextR, nextC});
				
			}
		}
		
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		

		for (int i = 0; i < T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());

			map = new int[N][M];
			visited = new boolean[N][M];

			for (int j = 0; j < K; j++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				map[y][x] = 1;
			}
			
			int worm = 0;
			for(int q = 0; q < N; q++) {
				for(int p = 0; p < M; p++) {
					if(map[q][p] == 1 && !visited[q][p]) {
						worm++;
						bfs(q, p);
					}
				}
			}
			System.out.println(worm);
			
		}
		br.close();
	}

}
