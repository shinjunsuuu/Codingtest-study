package junsu.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_11720 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int no = Integer.parseInt(br.readLine());
		String str = br.readLine();
		br.close();

		int ans = 0;
		for (char c : str.toCharArray()) {
		    ans += c - '0';
		}
		System.out.println(ans);

	}
}
