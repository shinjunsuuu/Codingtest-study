// 1260 실버2 DFS와 BFS
package Gihyun.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_1260 {
	static ArrayList<ArrayList<Integer>> ar = new ArrayList<>(); // 큰 틀 만들기
	static boolean []checkdfs; // 선언만 하고 객체는 아직 없음
	static boolean []checkbfs;

	public static void main(String[] args) throws IOException { //main은 무조건 static -> 호출하는 메소드도 static
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String []input = br.readLine().split(" ");
		int N = Integer.parseInt(input[0]); //정점
		int M = Integer.parseInt(input[1]); //간선
		int V = Integer.parseInt(input[2]); //시작숫자
		
		checkdfs = new boolean[N+1]; // 힙 메모리에 boolean 배열을 가리키고 자동으로 false로 초기화
		checkbfs = new boolean[N+1];
		
		for(int i=0;i<=N;i++) {
			ar.add(new ArrayList<>()); //new를 쓰면 매번 새로운 리스트가 생성 , 안쓰면 같은 리스트가 됨
		}
		
		
		for(int i=0;i<M;i++) {
			String []conn = br.readLine().split(" ");
			ar.get(Integer.parseInt(conn[0])).add(Integer.parseInt(conn[1]));
			ar.get(Integer.parseInt(conn[1])).add(Integer.parseInt(conn[0]));
		}
		
		for(int i=0;i<=N;i++) { // 간선 수(M)으로하면 터짐
			Collections.sort(ar.get(i)); // for문 -> 1차원 배열에 대해 적용하기 위함
		}
		
		dfs(V);
		System.out.print("\n");
		bfs(V);
	}
	
	static void dfs(int start) {
		checkdfs[start] = true;
		System.out.print(start+" ");
		
		for(int next : ar.get(start)) {
			if(!checkdfs[next]) { // checkdfs는 기본적으로 비어있으므로 false
				dfs(next);
			}
		}
	}
	
	static void bfs(int start) {
		Queue<Integer> q = new LinkedList<>();
		checkbfs[start] = true;
		q.offer(start);
		
		while(!q.isEmpty()) {
			int node = q.poll();
			System.out.print(node+" ");
			for(int next : ar.get(node)) {
				if(!checkbfs[next]){
					checkbfs[next] = true;
					q.offer(next);
				}
			}
		}
		
	}

}