// 2606 바이러스 실버3
package Gihyun.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BOJ_2606 {
	static ArrayList<ArrayList<Integer>> ar = new ArrayList<>();
	static boolean [] check;
	static int count = 0;
	

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		check = new boolean[n+1];
		int m = Integer.parseInt(br.readLine());
		
		for(int i=0;i<=n;i++) {
			ar.add(new ArrayList<>());
		}
		
		for(int i=0;i<m;i++) {
			String []input = br.readLine().split(" ");
			ar.get(Integer.parseInt(input[0])).add(Integer.parseInt(input[1]));
			ar.get(Integer.parseInt(input[1])).add(Integer.parseInt(input[0]));
		}
		
		dfs(1);
		System.out.print(count);
	}
	static void dfs(int start) {
		check[start] = true;
		for(int next : ar.get(start)) {
			if(!check[next]) {
				count++;
				dfs(next);
			}
		}
	}
}