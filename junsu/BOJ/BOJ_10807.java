package junsu.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_10807 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String str = br.readLine();
		for(char i = 'a'; i <= 'z'; i ++) {
			sb.append(str.indexOf(i) + " ");
		}
		System.out.println(sb);
	}

}
