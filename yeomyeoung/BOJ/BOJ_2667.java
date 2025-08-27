package BOJ;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_2667 {
    static int arr[][];
    static boolean visited[][];
    static int directionRow[] = {0, 1, 0, -1};
    static int directionCol[] = {-1, 0, 1, 0};
    static int group = 1;

    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int arrSize = Integer.parseInt(bf.readLine());

        arr = new int[arrSize][arrSize];
        visited = new boolean[arrSize][arrSize];

        for(int i = 0; i < arrSize; i++){
            char[] nums = bf.readLine().toCharArray();
            for(int j = 0; j < arrSize; j++){
                arr[i][j] = nums[j] - '0';
            }
        }

        ArrayList<Integer> A = new ArrayList<>();

        for(int i = 0; i < arrSize; i++){
            for(int j = 0; j < arrSize; j++){
                if(arr[i][j] == 1 && !visited[i][j]){
                    // visited[i][j] = true;                  // (FIX) 시작점 방문처리는 bfs() 안에서 하자
                    int size = bfs(i, j);                     // bfs 실행하고 시작점 포함 크기 반환
                    A.add(size);
                    group++;                                   // 단지 하나 끝난 뒤 그룹 번호 증가
                }
            }
        }

        Collections.sort(A);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(A.size()).append('\n');           // 단지 개수는 A.size()
        for(int i : A){
            stringBuilder.append(i).append('\n');
        }
        System.out.println(stringBuilder);
    }

    public static int bfs(int row, int col){
        Queue<int[]> queue = new LinkedList<>();
        visited[row][col] = true;                               // 시작점 방문 체크
        arr[row][col] = group;                                  // 라벨링(원하면 유지)
        queue.add(new int[] {row, col});                        // 시작점 큐 삽입
        int count = 1;                                          // 시작점 포함이므로 1

        // 현재 코드는 큐에 넣고 즉시 poll한 뒤 재귀(DFS처럼) → (FIX) BFS는 while 루프
        while(!queue.isEmpty()){
            int[] cur =  queue.poll();
            int r = cur[0];
            int c = cur[1];

            for(int i = 0; i < 4; i++){
                int nr = r + directionRow[i];
                int nc = c + directionCol[i];

                if(!(0 <= nr && nr < arr.length && 0 <= nc && nc < arr.length)){
                    continue;
                }
                if(visited[nr][nc]){
                    continue;
                }
                if(arr[nr][nc] != 1){
                    continue;
                }

                visited[nr][nc] = true;
                arr[nr][nc] = group;
                queue.add(new int[] {nr, nc});
                count++;
            }
        }
        return count;                                           // 단지 크기 반환
    }
}
