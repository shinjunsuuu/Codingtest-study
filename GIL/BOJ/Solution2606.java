package GIL.BOJ;

import java.io.*;
import java.util.*;

public class Solution2606 {
	
	static int N, M, count;
	static boolean[] visited;
	static boolean[][] graph;
	
	static void dfs(int idx) {
		visited[idx] = true;
		for(int i = 0; i <= N; i++) {
			if(!visited[i] && graph[idx][i])
				dfs(i);
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		
		visited = new boolean[N+1];
		graph = new boolean[N+1][N+1];
		
		for(int i = 1; i <= M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");

			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			graph[x][y] = graph[y][x] = true;
		}
		
		dfs(1);
		
		for(int i = 2; i <= N; i++) {
			if(visited[i])
				count++;
		}
		System.out.println(count);
		br.close();
	}

}
