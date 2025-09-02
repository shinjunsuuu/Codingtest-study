package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_2468 {
    static int size;
    static int[][] dol;
    static boolean[][] visited;

    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        size = Integer.parseInt(br.readLine());
        dol = new int[size][size];

        int maxHeight = 0;
        for (int x = 0; x < size; x++) {
            String[] str = br.readLine().split(" ");
            for (int y = 0; y < size; y++) {
                dol[x][y] = Integer.parseInt(str[y]);
                maxHeight = Math.max(maxHeight, dol[x][y]);
            }
        }

        int answer = 1; // 비가 하나도 안올 때 최소 1개
        for (int rain = 1; rain <= maxHeight; rain++) {
            visited = new boolean[size][size];
            int count = 0;

            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    if (!visited[i][j] && dol[i][j] > rain) {
                        bfs(i, j, rain);
                        count++;
                    }
                }
            }
            answer = Math.max(answer, count);
        }

        System.out.println(answer);
    }

    static void bfs(int r, int c, int rain) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{r, c});
        visited[r][c] = true;

        while (!q.isEmpty()) {
            int[] node = q.poll();
            int x = node[0];
            int y = node[1];

            for (int dir = 0; dir < 4; dir++) {
                int nx = x + dx[dir];
                int ny = y + dy[dir];

                if (nx < 0 || ny < 0 || nx >= size || ny >= size) continue;

                if (!visited[nx][ny] && dol[nx][ny] > rain) {
                    visited[nx][ny] = true;
                    q.offer(new int[]{nx, ny});
                }
            }
        }
    }
}
