import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_1260 {
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine()); // 노드(점)의 개수
        int m = Integer.parseInt(br.readLine()); // 간선의 갯수

        visited = new boolean[n + 1];

        // 그래프 초기화 (빈 상자 준비)
        for (int i = 0; i <= n; i++) {
           graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
           StringTokenizer st = new StringTokenizer(br.readLine());
           int a = Integer.parseInt(st.nextToken());
           int b = Integer.parseInt(st.nextToken());
           addEdge(a, b); // 간선(점과 점을 연결) 추가
            
        }

       
       

       // System.out.println("DFS 탐색 시작:");
        dfs(1); // 1번 점에서 시작
        
    }

    static void addEdge(int a, int b) {
        graph.get(a).add(b); // a에 b를 연결
        graph.get(b).add(a); // b에도 a 연결 (양방향)
    }

    static void dfs(int node) {
        
        visited[node] = true; // 방문했다고 체크
        
        for (int next : graph.get(node)) { // 현재 노드와 연결된 노드 확인
            if (!visited[next]) {          // 아직 방문 안 했다면
             dfs(next); // 그쪽으로 깊게 들어감
             }
        }
        
    }


    static ArrayList<ArrayList<Integer>> Bgraph = new ArrayList<>();
    static boolean[] Bvisited;

    public static void BFS (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int bn = Integer.parseInt(br.readLine()); // 노드(점)의 개수
        int bm = Integer.parseInt(br.readLine()); // 간선의 갯수
        
        visited = new boolean[bn + 1];

        // 그래프 초기화
        for (int i = 0; i <= bn; i++) {
           graph.add(new ArrayList<>());
        }

        for (int i = 0; i < bm; i++) {
           StringTokenizer st = new StringTokenizer(br.readLine());
           int a = Integer.parseInt(st.nextToken());
           int b = Integer.parseInt(st.nextToken());
           addEdge(a, b); // 간선(점과 점을 연결) 추가
            
        }

        System.out.println("BFS 탐색 시작:");
        bfs(1); // 1번 노드에서 시작
    }

    static void BaddEdge(int a, int b) {
        graph.get(a).add(b);
        graph.get(b).add(a);
    }

    static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>(); // 큐 준비
        visited[start] = true;                 // 시작점 방문 체크
        q.offer(start);                        // 시작점 큐에 넣기

        while (!q.isEmpty()) {                 // 큐가 빌 때까지 반복
            int node = q.poll();               // 가장 먼저 들어온 노드 꺼내기
            System.out.println(node);          // 출력

            for (int next : graph.get(node)) { // 이웃 노드들 확인
                if (!visited[next]) {          // 아직 방문 안 했으면
                    visited[next] = true;      // 방문 체크하고
                    q.offer(next);             // 큐에 넣기 (줄 뒤에 세우기)
                }
            }
        }
    }

    
}


