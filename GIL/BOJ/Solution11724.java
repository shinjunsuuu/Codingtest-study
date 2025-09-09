package GIL.BOJ;

import java.io.*;
import java.util.*;

public class Solution11724 {

	static int N, M;
	static boolean[] visited;
	static boolean[][] graph;
	static int count;
	
	static void dfs(int idx) {
		visited[idx] = true;
		for(int i=1; i<=N; i++) {
			if(!visited[i] && graph[idx][i])
				dfs(i);
		}
	}
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		visited = new boolean[N + 1];
		graph = new boolean[N+1][N+1];
		
		for(int i = 1; i <= M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			graph[x][y] = graph[y][x] = true;
		}
		
		for(int i = 1; i <= N; i++) {
			if(!visited[i])
				count++;
			dfs(i);
		}
		System.out.println(count);
		br.close();
		
		
	}

}
