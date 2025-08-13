package GIL;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution2920 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
		String[] num = line.split(" ");
		String combinedString = String.join("", num);
		String ascending = "12345678";
		String descending = "87654321";
		System.out.println(combinedString);
		if(combinedString.equals(ascending)) {
			System.out.println("ascending");
		} else if (combinedString.equals(descending)) {
			System.out.println("descending");
		} else {
			System.out.println("mixed");
		}
		br.close();
	}
}
