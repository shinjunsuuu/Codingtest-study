// 실버2 | 점프 점프 | 14128
package Gihyun.BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_14248{
	static ArrayList<Integer> ar = new ArrayList<>();
	static boolean check [];
	static int n;
	static int count;

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		ar = new ArrayList<Integer>(n+1);
		ar.add(0); // 0번 인덱스에 0을 넣어야 밑에 1번 인덱스부터 값이 제대로 들어감
		check = new boolean [n+1];
		
		String input [] = br.readLine().split(" ");
		for(int i=1;i<=n;i++) {
			ar.add(Integer.parseInt(input[i-1]));
		}
		
		int s= Integer.parseInt(br.readLine());
		
		bfs(s);
		System.out.print(count);
	}
	
	static void bfs(int start) {
		Queue<Integer> q = new LinkedList<>();
		check[start] = true;
		q.offer(start);
		count = 1;
		
		while(!q.isEmpty()) {
			int index = q.poll();
			int dx [] = {index-ar.get(index),index+ar.get(index)};
			for(int next : dx) {
				if(next>=1&&next<=n&&!check[next]) {
					check[next] = true;
					q.offer(next);
					count++;
				}
			}
			
		}
	}

}