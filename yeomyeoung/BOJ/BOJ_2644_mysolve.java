package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;


public class BOJ_2644_mysolve {
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static boolean visited[];
    static int answer = -1;
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int person = Integer.parseInt(bufferedReader.readLine());

        st = new StringTokenizer(bufferedReader.readLine());
        int firstPerson = Integer.parseInt(st.nextToken());
        int secondPerson = Integer.parseInt(st.nextToken());

        int ways = Integer.parseInt(bufferedReader.readLine());

        for (int i = 0; i <= person; i++) graph.add(new ArrayList<>());

        for (int i = 0; i < ways; i++) {
            st = new StringTokenizer(bufferedReader.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        visited = new boolean[person + 1];


        for(int i = 0; i <= person; i++) {
            graph.add(new ArrayList<>());
        }


        for (int i = 0; i < ways; i++) {
            String line = bufferedReader.readLine();
//            System.out.println("RAW=[" + line + "]");
            StringTokenizer stringTokenizer = new StringTokenizer(line);

            int firstNode = Integer.parseInt(stringTokenizer.nextToken());
            int secondNode = Integer.parseInt(stringTokenizer.nextToken());
//            System.out.println("PARSED=" + firstNode + " " + secondNode);

            graph.get(firstNode).add(secondNode);
            graph.get(secondNode).add(firstNode);
        }

        for (int i = 1; i <= person; i++){
            Collections.sort(graph.get(i));
        }

        dfs(firstPerson, secondPerson, 0);
        System.out.println(answer);


    }
    public static void dfs(int start, int target, int depth){
        if(answer != -1 && depth >= answer){
            return;
        }

        if (start == target){
            answer = depth;
            return;
        }

        visited[start] = true;

//        System.out.println(start);
        for(int i : graph.get(start)){
//            System.out.println(i);
            if(!visited[i]){
                dfs(i, target, depth + 1);
            }
        }
        visited[start] = false;
    }
}
