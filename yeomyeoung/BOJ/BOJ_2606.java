package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2606 {
    static boolean[][] visited;
    static int[][] map;
    static int nodes;
    static int ways;

    public static void main(String[] args) throws Exception{
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        nodes = Integer.parseInt( stringTokenizer.nextToken());
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        ways = Integer.parseInt( stringTokenizer.nextToken());

        map = new int[nodes][nodes];
        visited = new boolean[nodes][nodes];
    }
}
