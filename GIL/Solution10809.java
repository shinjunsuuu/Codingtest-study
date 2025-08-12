package GIL;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution10809 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
		String[] ln = line.split("");
		String alphabet = "abcdefghijklmnopqrstuvwxyz";
		int[] resultList = new int[26];
		for (int i = 0; i < 26; i++) {
			resultList[i] = -1;
		}
		
		for (int j = 0; j < ln.length; j++) {
			 resultList[alphabet.indexOf(ln[j])] = resultList[alphabet.indexOf(ln[j])] != -1 ? resultList[alphabet.indexOf(ln[j])] : j;
			
		}

		for (int i = 0; i < resultList.length; i++) {
			System.out.print(resultList[i]);
			if(i != resultList.length -1) {
				System.out.print(" ");
			}
		}
		
		
		br.close();

	}

}
