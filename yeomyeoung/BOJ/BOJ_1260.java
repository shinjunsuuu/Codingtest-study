package BOJ;


import java.util.*;


public class BOJ_1260{
    static boolean visited[];
    static ArrayList<Integer>A[];
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int nodes = scanner.nextInt();
        int ways = scanner.nextInt();
        int startNode = scanner.nextInt();
        A = new ArrayList[nodes + 1];

        for (int i = 1; i <= nodes; i++){
            A[i] = new ArrayList<Integer>();
        }


        for (int i = 0; i < ways; i++) {
            int firstNode = scanner.nextInt();
            int secondNode = scanner.nextInt();
            A[firstNode].add(secondNode);
            A[secondNode].add(firstNode);
        }

        for (int i = 1; i <= nodes; i++){
            Collections.sort(A[i]);
        }

        visited = new boolean[nodes + 1];
        DFS(startNode);
        System.out.println();


        visited = new boolean[nodes + 1];
        BFS(startNode);
        System.out.println();

    }

    private static void BFS(int startNode) {
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(startNode);
        visited[startNode] = true;

        while (!queue.isEmpty()){
            int now_Node = queue.poll();
            System.out.print(now_Node + " ");
            for(int j : A[now_Node]){
                if (!visited[j]){
                    visited[j] = true;
                    queue.add(j);
                }
            }
        }
    }

    private static void DFS(int startNode) {
        System.out.print(startNode + " ");
        visited[startNode] = true;
        for(int i : A[startNode]){
            if(!visited[i]){
                DFS(i);
            }
        }
    }

}
