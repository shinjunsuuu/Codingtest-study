// 2644 촌수계산 실버2
package Gihyun.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BOJ_2644 {
	static ArrayList<ArrayList<Integer>> ar = new ArrayList<>();
	static boolean [] check;
	static int one, two;
	static int count = 0;
	static int result = -1;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		check = new boolean[n+1];
		String []relation = br.readLine().split(" ");
		one = Integer.parseInt(relation[0]);
		two = Integer.parseInt(relation[1]);
		int m = Integer.parseInt(br.readLine());
		
		for(int i=0;i<=n;i++) {
			ar.add(new ArrayList<>());
		}
		
		for(int i=0;i<m;i++) {
			String [] input = br.readLine().split(" ");
			ar.get(Integer.parseInt(input[0])).add(Integer.parseInt(input[1]));
			ar.get(Integer.parseInt(input[1])).add(Integer.parseInt(input[0]));
		}
		
		dfs(one);
		System.out.print(result);
	}
	
	static void dfs(int start) {
		check[start] = true;
		if(start == two) {
			result = count;
			return;
		}
		
		for(int next : ar.get(start)) {
			if(!check[next]) {
				count++;
				dfs(next);  // 한쪽 끝노드가 끝나고 아래줄이 실행됨
				count --;   // 백트래킹에 따른 count 감쇠
			}
		}
	}

}