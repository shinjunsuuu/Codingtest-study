// 2908 / 상수 / 브론즈2
package Gihyun.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2908 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String []input = br.readLine().split(" ");
		int []output = new int[input.length];
		
		for(int i=0;i<input.length;i++) {
			StringBuilder sb = new StringBuilder(input[i]);
			output[i] = Integer.parseInt(sb.reverse().toString());
		}
		
		int max = Math.max(output[0], output[1]);
		System.out.println(max);
	}

}
