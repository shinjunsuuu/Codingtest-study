import java.io.BufferedReader;

import java.io.IOException;

import java.io.InputStreamReader;

import java.util.*;

public class BOJ_24444 {

    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

    static boolean[] visited;

    static int[] order;  // 방문 순서 저장

    static int cnt = 1;  // 방문 순서 카운터

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] str = br.readLine().split(" ");

        int n = Integer.parseInt(str[0]);

        int m = Integer.parseInt(str[1]);

        int r = Integer.parseInt(str[2]);

        visited = new boolean[n + 1];

        order = new int[n + 1];

        // 그래프 초기화

        for (int i = 0; i <= n; i++) {

            graph.add(new ArrayList<>());

        }

        // 간선 입력

        for (int i = 0; i < m; i++) {

            String[] edge = br.readLine().split(" ");

            int a = Integer.parseInt(edge[0]);

            int b = Integer.parseInt(edge[1]);

            graph.get(a).add(b);

            graph.get(b).add(a);

        }

        // 인접 리스트 오름차순 정렬

        for (int i = 1; i <= n; i++) {

            Collections.sort(graph.get(i));

        }

        bfs(r);

        // 각 노드 방문 순서 출력

        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= n; i++) {

            sb.append(order[i]).append("\n");

        }

        System.out.print(sb);

    }

    static void bfs(int start) {

        Queue<Integer> q = new LinkedList<>();

        visited[start] = true;

        order[start] = cnt++;

        q.offer(start);

        while (!q.isEmpty()) {

            int node = q.poll();

            for (int next : graph.get(node)) {

                if (!visited[next]) {

                    visited[next] = true;

                    order[next] = cnt++;

                    q.offer(next);

                }

            }

        }

    }

}

