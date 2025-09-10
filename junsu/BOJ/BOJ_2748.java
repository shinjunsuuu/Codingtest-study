package junsu.BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;
public class BOJ_2748 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int input = Integer.parseInt(br.readLine());
		long[] arr = new long[input+1];
		
		arr[0] = 0;
		arr[1] = 1;
		
		for(int i=2;i<=input;i++) {
			arr[i] = arr[i-1] + arr[i-2];
		}
		
		System.out.println(arr[input]);
	}

}