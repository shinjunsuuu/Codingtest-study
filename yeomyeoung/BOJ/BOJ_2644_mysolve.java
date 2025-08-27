package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;


public class BOJ_2644_mysolve {
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static boolean visited[];
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int person = Integer.parseInt(bufferedReader.readLine());
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        int firstPerson = Integer.parseInt(stringTokenizer.nextToken());
        int secondPerson = Integer.parseInt(stringTokenizer.nextToken());

        int ways = Integer.parseInt(bufferedReader.readLine());
        visited = new boolean[ways];

        int answer = 0;

        for(int i = 0; i <= person; i++) {
            graph.add(new ArrayList<>());
        }


        for (int i = 0; i < ways; i++) {
            String line = bufferedReader.readLine();
//            System.out.println("RAW=[" + line + "]");
            StringTokenizer st = new StringTokenizer(line);

            int firstNode = Integer.parseInt(st.nextToken());
            int secondNode = Integer.parseInt(st.nextToken());
//            System.out.println("PARSED=" + firstNode + " " + secondNode);

            graph.get(firstNode).add(secondNode);
            graph.get(secondNode).add(firstNode);
        }

        for (int i = 1; i <= ways; i++){
            Collections.sort(graph.get(i));
        }

        DFS(firstPerson);


    }
    public static void DFS(int start){
        visited[start] = true;
        System.out.println(start);
        for(int i : graph.get(start)){
            System.out.println(i);
            if(!visited[i]){
                DFS(i);
            }
        }
    }
}
