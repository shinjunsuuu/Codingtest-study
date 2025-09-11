import java.io.BufferedReader;

import java.io.IOException;

import java.io.InputStreamReader;

import java.util.*;

public class BOJ_1926 {

    static int mx, my;

    static int[][] map;

    static boolean[][] visited;

    static int[] dx = {0, 1, 0, -1};

    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] size = br.readLine().split(" ");

        mx = Integer.parseInt(size[0]);

        my = Integer.parseInt(size[1]);

        map = new int[mx][my];

        for (int x = 0; x < mx; x++) {

            String[] str = br.readLine().split(" ");

            for (int y = 0; y < my; y++) {

                map[x][y] = Integer.parseInt(str[y]);

            }

        }

        visited = new boolean[mx][my];

        int count = 0;   // 그림 개수

        int maxSize = 0; // 가장 큰 그림 넓이

        for (int i = 0; i < mx; i++) {

            for (int j = 0; j < my; j++) {

                if (!visited[i][j] && map[i][j] > 0) {

                    int sizeOfPicture = bfs(i, j);

                    count++;

                    maxSize = Math.max(maxSize, sizeOfPicture);

                }

            }

        }

        System.out.println(count);

        System.out.println(maxSize);

    }

    static int bfs(int r, int c) {

        Queue<int[]> q = new LinkedList<>();

        q.offer(new int[]{r, c});

        visited[r][c] = true;

        int size = 1; // 시작점 포함

        while (!q.isEmpty()) {

            int[] node = q.poll();

            int x = node[0];

            int y = node[1];

            for (int dir = 0; dir < 4; dir++) {

                int nx = x + dx[dir];

                int ny = y + dy[dir];

                if (nx < 0 || ny < 0 || nx >= mx || ny >= my) continue;

                if (!visited[nx][ny] && map[nx][ny] > 0) {

                    visited[nx][ny] = true;

                    q.offer(new int[]{nx, ny});

                    size++;

                }

            }

        }

        return size;

    }

}

