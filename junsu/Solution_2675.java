package junsu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_2675 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder out = new StringBuilder();
		
		int num = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < num; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			String s = st.nextToken();
			
			for(int j = 0; j < s.length(); j++) {
				out.append(String.valueOf(s.charAt(j)).repeat(x));
			}
			out.append('\n');
		}
		System.out.println(out);
		br.close();
	}

}
