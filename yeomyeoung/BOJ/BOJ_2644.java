package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ_2644 {
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static boolean visited[];
    static int answer = -1; // ✅ [ADDED] 도달 못하면 -1을 출력하기 위한 기본값

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int person = Integer.parseInt(bufferedReader.readLine());
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        int firstPerson = Integer.parseInt(stringTokenizer.nextToken());
        int secondPerson = Integer.parseInt(stringTokenizer.nextToken());

        int ways = Integer.parseInt(bufferedReader.readLine());
        visited = new boolean[person + 1]; // ✅ [CHANGED] 간선 수(ways) → 정점 수(person) 기준으로 변경

        int answer = 0; // ❌ [OPTIONAL] 사용하지 않음 (위의 전역 answer 사용). 필요 없다면 제거 가능.

        for (int i = 0; i <= person; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < ways; i++) {
            String line = bufferedReader.readLine();
            StringTokenizer st = new StringTokenizer(line);

            int firstNode = Integer.parseInt(st.nextToken());
            int secondNode = Integer.parseInt(st.nextToken());

            graph.get(firstNode).add(secondNode);
            graph.get(secondNode).add(firstNode);
        }

        for (int i = 1; i <= person; i++){         // ✅ [CHANGED] 정렬 범위를 ways → person 으로
            Collections.sort(graph.get(i));
        }

        DFS(firstPerson, secondPerson, 0);          // ✅ [CHANGED] 백트래킹용 파라미터(목표/깊이) 추가 호출

        System.out.println(answer);                 // ✅ [ADDED] DFS 결과(촌수) 출력
    }

    // ✅ [CHANGED] 시그니처 변경: (현재정점, 목표정점, 현재깊이)
    public static void DFS(int current, int target, int depth){
        if (current == target) {         // ✅ [ADDED] 목표에 도달하면 현재 깊이가 촌수
            answer = depth;
            return;
        }

        visited[current] = true;         // (기존 방문 처리 유지)

        for (int next : graph.get(current)){
            if(!visited[next]){
                DFS(next, target, depth + 1);   // ✅ [CHANGED] 한 단계 더 내려가므로 깊이 +1
            }
        }
    }
}
