// 11724 연결 요소의 개수 실버2
package Gihyun.BOJ;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BOJ_11724 {
	static ArrayList<ArrayList<Integer>> ar = new ArrayList<>();
	static boolean [] check;
	static int result = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String []input = br.readLine().split(" ");
		int N = Integer.parseInt(input[0]);
		check = new boolean[N+1];
		int M = Integer.parseInt(input[1]);
		
		for(int i=0;i<=N;i++) {
			ar.add(new ArrayList<>());
		}
		
		for(int i=0;i<M;i++) {
			String []conn = br.readLine().split(" ");
			ar.get(Integer.parseInt(conn[0])).add(Integer.parseInt(conn[1]));
			ar.get(Integer.parseInt(conn[1])).add(Integer.parseInt(conn[0]));
		}
		
		for(int i=1;i<=N;i++) {
			if(dfs(i)) {
				continue;
			};
			result++;
		}
		System.out.print(result);
	}
	
	static boolean dfs(int start) {
		if(check[start]) {
			return true;
		}
			check[start] = true;
			for(int next:ar.get(start)) {
				if(!check[next]) {
					dfs(next); //dfs 재귀함수 실행하면 for문 밖에도 실행됨      
				}
			} return false;
		}
}