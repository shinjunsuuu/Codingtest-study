package BOJ;

import java.io.*;
import java.util.*;


public class BOJ_2468 {
    static int[][] map;
    static boolean[][] visited;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};
    static int[] cur = {0, 0};
    static int currentLimit = 0;
    static int arrLength;
    static int groupCount, maxNum, temp;



    public static void main(String[] args) throws Exception{
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        arrLength = Integer.parseInt(stringTokenizer.nextToken());

        map = new int[arrLength][arrLength];
        visited = new boolean[arrLength][arrLength];

        groupCount = maxNum = temp = 0;

        for(int i = 0; i < arrLength; i++){
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for(int j = 0; j < arrLength; j++){
                temp = Integer.parseInt(stringTokenizer.nextToken());
                if(maxNum < temp){
                    maxNum = temp;
                }
                map[i][j] = temp;
            }
        }

        ArrayList<Integer> findMaxGroup = new ArrayList<>();


        for(int i = 0; i < maxNum; i++){
            doBfs();
            findMaxGroup.add(groupCount);
            resetGroupCount();
            resetVisited();
            currentLimit++;
        }

        Collections.sort(findMaxGroup);
        System.out.println(findMaxGroup.get(findMaxGroup.size() - 1));
//        System.out.println(maxNum);
    }

    private static void resetGroupCount() {
        groupCount = 0;
    }

    private static void resetVisited() {
        for(int i = 0; i < visited.length; i++){
            for(int j = 0; j < visited.length; j++){
                visited[i][j] = false;
            }
        }
    }

    public static void doBfs(){
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map.length; j++) {
                if (0 < map[i][j] && !visited[i][j] && currentLimit < map[i][j]) {
                    bfs(i, j);
                    groupCount++;
                }
            }
        }
    }

    public static void bfs(int row, int col){
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{row, col});
        visited[row][col] = true;

        while (!queue.isEmpty()){
            cur = queue.poll();
            for(int i = 0; i < 4; i++){
                int nr = cur[0] + dr[i];
                int nc = cur[1] + dc[i];
                if(!(0 <= nr && nr < arrLength && 0 <= nc && nc < arrLength)){
                    continue;
                }
                if(map[nr][nc] <= currentLimit){
                    continue;
                }
                if(visited[nr][nc]){
                    continue;
                }

                queue.offer(new int[]{nr, nc});
                visited[nr][nc] = true;
//                System.out.println(map[nr][nc]);
            }
        }

    }
}
