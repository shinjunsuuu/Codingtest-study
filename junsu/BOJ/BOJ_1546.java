package junsu.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1546 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int result = n;
		for(int i = 0; i < n; i++) {
			String s = br.readLine();
			
			for(int j = 0; j<s.length()-1;j++) {
				if(s.charAt(j) == s.charAt(j+1)) {
					continue;
				}
				else if(s.substring(j + 1).indexOf(s.charAt(j)) != -1) {
					result -= 1;
					break;
				}
			}
			
		}
		System.out.println(result);
	}

}
