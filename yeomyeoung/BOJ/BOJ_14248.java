package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_14248 {

    static int[] map;
    static boolean[] visited;
    static int mapSize, startIndex, countVisit, indexTemp;

    public static void main(String[] args) throws Exception{
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        mapSize = Integer.parseInt(stringTokenizer.nextToken());

        map = new int[mapSize];
        visited = new boolean[mapSize];

        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < mapSize; i++){
            map[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        startIndex = Integer.parseInt(stringTokenizer.nextToken()) - 1;

        jump(startIndex);

        System.out.println(countVisit);
    }

    private static void jump(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        visited[start] = true;
        countVisit = 1; // 시작점 포함

        while (!q.isEmpty()) {
            int cur = q.poll();
            int step = map[cur];

            int left = cur - step;
            int right = cur + step;

            if (left >= 0 && !visited[left]) {
                visited[left] = true;  // 큐 넣을 때 방문 처리
                q.offer(left);
                countVisit++;
            }
            if (right < mapSize && !visited[right]) {
                visited[right] = true; // 큐 넣을 때 방문 처리
                q.offer(right);
                countVisit++;
            }
        }
    }


//    private static void jump(int index) {
//        Queue<Integer> plusQueue = new LinkedList<>();
//        visited[index] = true;
//
//        plusQueue.offer(index);
//        countVisit++;
//
//        while(!plusQueue.isEmpty()){
//            int indexTemp = plusQueue.poll();
//            visited[indexTemp] = true;
//
//            if(mapSize < map[indexTemp] + index){
//                continue;
//            }
//
//            if(map[indexTemp] - index < 0){
//                continue;
//            }
//
//            if((((map[indexTemp]) + index) < mapSize) && !(visited[indexTemp + index])){
//                plusQueue.offer(indexTemp + index);
//                countVisit++;
//            }
//
//            if(((0 < (map[indexTemp]) - index)) && !(visited[indexTemp - index])){
//                plusQueue.offer(indexTemp - index);
//                countVisit++;
//            }


//            if((map[indexTemp]) - index < 0){
//                if(){
//                    continue;
//                }
//                else{
//                    plusQueue.offer(map[indexTemp - index]);
//                    countVisit++;
//                    visited[index] = true;
//                }
//            }


//    }

}
