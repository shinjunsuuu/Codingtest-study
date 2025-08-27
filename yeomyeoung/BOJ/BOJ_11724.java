package BOJ;

import java.io.*;
import java.util.*;

public class BOJ_11724 {
    static ArrayList<ArrayList<Integer>> map = new ArrayList<>();
    static boolean[] visited;
    public static void main(String[] args) throws Exception{
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bufferedReader.readLine());

        int nodes = Integer.parseInt(st.nextToken());
        int ways = Integer.parseInt(st.nextToken());
        visited = new boolean[nodes + 1];

        for (int i = 0; i <= nodes; i++) {
            map.add(new ArrayList<>());
        }

        for (int i = 0; i < ways; i++){
            st = new StringTokenizer(bufferedReader.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            map.get(u).add(v);
            map.get(v).add(u);
        }

        int count = 0;
        for (int i = 1; i <= nodes; i++) {
            if (!visited[i]) {
                dfs(i);
                count++;
            }
        }

        System.out.println(count);
    }

    static void dfs(int v) {
        visited[v] = true;
        for (int nxt : map.get(v)) {
            if (!visited[nxt]) dfs(nxt);
        }
    }
}
