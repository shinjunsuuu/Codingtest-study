package junsu.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_2750 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int x = Integer.parseInt(br.readLine());
		int arr[] = new int[x];
		
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0;i < x; i++) {
			arr[i]=Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(arr);
		
		for(int i = 0; i < x; i++) {
			sb.append(arr[i]).append("\n");
		}
		
		System.out.println(sb);
	}

}
