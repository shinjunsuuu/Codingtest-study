package GIL.BOJ;

import java.io.*;
import java.util.*;

public class BOJ2468 {

	static int N;
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };
	static int[][] map;
	static boolean[][] visited;
	
	public static void bfs(int sr, int sc, int rainLevel) {
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] { sr, sc });
		visited[sr][sc] = true;
		
		while(!queue.isEmpty()) {
			int[] cur = queue.poll();
			int curR = cur[0];
			int curC = cur[1];
			
			for(int i = 0; i < 4; i++) {
				int nextR = curR + dr[i];
				int nextC = curC + dc[i];
				
				if(nextR < 0 || nextR >= N || nextC < 0 || nextC >= N) continue;
				if(visited[nextR][nextC]) continue;
				
				if(map[nextR][nextC] > rainLevel){
					visited[nextR][nextC] = true;
					queue.offer(new int[] { nextR, nextC });
				}
				
			}
		}
		
	}
	
	

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		int maxHeight = 0;
		StringTokenizer st;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());

			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] > maxHeight) {
					maxHeight = map[i][j];
				}
			}
		}
		 // --- 시뮬레이션 시작 ---
        int maxSafeAreaCount = 0;

        // 비의 양(rainLevel)을 0부터 maxHeight까지 바꿔가며 시도
        for (int rainLevel = 0; rainLevel <= maxHeight; rainLevel++) {
            visited = new boolean[N][N]; // 매 시뮬레이션마다 visited 배열 초기화
            int currentSafeAreaCount = 0; // 현재 시뮬레이션의 안전 영역 개수

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    // 물에 잠기지 않았고, 아직 방문 안 한 새로운 안전 영역을 찾았다면
                    if (map[i][j] > rainLevel && !visited[i][j]) {
                        currentSafeAreaCount++;
                        bfs(i, j, rainLevel); // 연결된 모든 안전 영역을 방문 처리
                    }
                }
            }
            // 이번 시뮬레이션의 결과와 기존 최댓값 비교하여 갱신
            maxSafeAreaCount = Math.max(maxSafeAreaCount, currentSafeAreaCount);
        }

        // 아무 지역도 물에 잠기지 않는 경우(비가 안 오는 경우)도 하나의 안전 영역이므로
        // 최솟값은 1이 되어야 합니다. (모든 지역의 높이가 0인 경우는 없으므로)
        // 하지만 만약 아무 지역도 없는 N=0 케이스 등이 있다면 0이 될 수도 있습니다.
        // 문제 조건에 따라, 비가 오지 않았을 때 영역은 1개이므로, maxSafeAreaCount가 0이면 1로 처리해줍니다.
        // (보통은 rainLevel=0일 때 currentSafeAreaCount가 1 이상이 되므로 이 코드는 필요 없을 수 있습니다.)
        if (maxSafeAreaCount == 0) maxSafeAreaCount = 1;


        System.out.println(maxSafeAreaCount);
    }
	

}
