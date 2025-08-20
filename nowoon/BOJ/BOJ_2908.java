package nowoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2908 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		
		String[] a = str.split(" ");    //공백으로 구분된 문자열 str을 분리하여 String[] 배열로 반환
		
		int int1 = Integer.parseInt(new StringBuilder(a[0]).reverse().toString());
		int int2 = Integer.parseInt(new StringBuilder(a[1]).reverse().toString());
		
		System.out.println(int1 > int2 ? int1:int2);

	}

}