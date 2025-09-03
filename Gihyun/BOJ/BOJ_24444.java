// 실버2 | 알고리즘 수업-너비 우선 탐색1 | 24444
// int 배열은 default 0으로 초기화, arraylist는 0으로 초기화되지않음
package Gihyun.BOJ;

import java.io.*;
import java.util.*;

public class BOJ_24444 {
	static ArrayList<ArrayList<Integer>> ar = new ArrayList<>();
	static boolean check[];
	static int order[];
	static int count;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input[] = br.readLine().split(" ");
		int N = Integer.parseInt(input[0]);
		int M = Integer.parseInt(input[1]);
		int R = Integer.parseInt(input[2]);
		check = new boolean[N + 1];
		order = new int[N + 1];

		for (int i = 0; i <= N; i++) {
			ar.add(new ArrayList<>());
		}

		String conn[];
		for (int i = 0; i < M; i++) {
			conn = br.readLine().split(" ");
			ar.get(Integer.parseInt(conn[0])).add(Integer.parseInt(conn[1]));
			ar.get(Integer.parseInt(conn[1])).add(Integer.parseInt(conn[0]));
		}

		for (int i = 1; i <= N; i++) {
			Collections.sort(ar.get(i));
		}

		bfs(R);
		for(int i=1;i<N+1;i++) {
			System.out.println(order[i]);
		}
	}

	static void bfs(int start) {
		Queue<Integer> q = new LinkedList<>();
		check [start] = true;
		q.offer(start);
		order[start] = ++count;
		
		while(!q.isEmpty()) {
			int out = q.poll();
			for(int next : ar.get(out)) {
				if(!check[next]) {
					check[next] = true;
					q.offer(next);
					order[next] = ++count;
				}
			}
		}
	}
}