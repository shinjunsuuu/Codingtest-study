package BOJ;

import java.io.*;
import java.util.*;

public class BOJ_1926 {

    static boolean[][] visited;
    static int[][] map;
    static int x, y;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int group = 0;
    static int groupCount = 0;

    public static void main(String[] args) throws Exception{
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        x = Integer.parseInt(stringTokenizer.nextToken());
        y = Integer.parseInt(stringTokenizer.nextToken());

        visited = new boolean[x][y];
        map = new int[x][y];

        for(int i = 0; i < x; i++){
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for (int j = 0; j < y; j++){
                map[i][j] = Integer.parseInt(stringTokenizer.nextToken());
//                System.out.println(map[i][j]);
            }
        }

        ArrayList<Integer> arrayList = new ArrayList<>();

        for(int i = 0; i < x; i++){
            for (int j = 0; j < y; j++){
                groupCount = 0;
                if (!visited[i][j] && map[i][j] == 1){
                    int size = bfs(i, j);
                    arrayList.add(size);
                    group++;
                }
            }
        }


        System.out.println(group);
        int max = 0;
        if (!arrayList.isEmpty()) {
            max = Collections.max(arrayList);
        }
        System.out.println(max);
//        System.out.println(arrayList.get(group));


//        System.out.println(arrayList.get(group));
    }

    public static int bfs(int row, int col){
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {row, col});
        visited[row][col] = true;

        while (!queue.isEmpty()) {
            groupCount++;
            int[] deQue = queue.poll();

            for (int i = 0; i < 4; i++) {
                int newRow = deQue[0] + dx[i];
                int newCol = deQue[1] + dy[i];

                if (!(0 <= newRow && newRow < x && 0 <= newCol && newCol < y)) {
                    continue;
                }

                if (map[newRow][newCol] != 1) {
                    continue;
                }

                if (visited[newRow][newCol]) {
                    continue;
                }

                visited[newRow][newCol] = true;
                queue.offer(new int[]{newRow, newCol});
            }
        }
        return groupCount;
    }
}
