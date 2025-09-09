package GIL.BOJ;

import java.io.*;
import java.util.*;

public class BOJ14248 {

	static int n, s, count;
	static int[] map;
	static boolean[] visited;

	static void dfs(int idx) {
		if (idx < 0 || idx >= n || visited[idx]) {
			return;
		}

		visited[idx] = true;
		count++;

		int jump = map[idx];
		dfs(idx + jump);
		dfs(idx - jump);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());

		map = new int[n];
		visited = new boolean[n];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < map.length; i++) {
			map[i] = Integer.parseInt(st.nextToken());
		}

		s = Integer.parseInt(br.readLine());
		dfs(s - 1);
		System.out.println(count);
		br.close();
	}

}
