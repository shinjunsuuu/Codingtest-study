package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_2667_re {
    static int arrSize;
    static int map[][];
    static boolean visited[][];
    static int[] searchRow = {-1, 0, 1, 0};
    static int[] searchCol = {0, 1, 0, -1};
    static int group = 1;

    public static void main(String[] args) throws Exception{
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        arrSize = Integer.parseInt(bufferedReader.readLine());
//        System.out.println(arrSize);
        map = new int[arrSize][arrSize];
        visited = new boolean[arrSize][arrSize];

        for(int i = 0; i < arrSize; i++){
            char[] nums = bufferedReader.readLine().toCharArray();
            for(int j = 0; j < arrSize; j++){
                map[i][j] = nums[j] - '0';
//                System.out.println(map[i][j]);
            }
//            System.out.println();
        }

        for(int i = 0; i < arrSize; i++){
            for(int j = 0; j < arrSize; j++){
                if (map[i][j] == 1 && !visited[i][j]){
                    bfs(i, j);
                }
            }
        }
//        group++;
        System.out.println(group);
    }

    public static void bfs(int row, int col){
        visited[row][col] = true;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {row, col});
        int arrToUse[] = queue.poll();

        for(int i = 0; i < 4; i++){
            int nr = arrToUse[0] + searchRow[i];
            int nc = arrToUse[1] += searchCol[i];

            if(!(0 <= nr && nr < arrSize && 0 <= nc && nc < arrSize)){
                continue;
            }

            if (map[nr][nc] != 1) {
                continue;
            }

            if(visited[nr][nc]){
                continue;
            }

            map[nr][nc] = group;
            bfs(nr, nc);
        }
        group++;
    }
}
