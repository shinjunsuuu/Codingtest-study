package GIL.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution2908 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
		String[] n = line.split(" ");
		
		StringBuilder sb = new StringBuilder();

		sb.setLength(0);
		sb.append(n[0]);
		int a = Integer.parseInt(sb.reverse().toString());
		sb.setLength(0);
		sb.append(n[1]);
		int b = Integer.parseInt(sb.reverse().toString());
		
		System.out.println(Math.max(a, b));
		
	}

}

