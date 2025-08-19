// 1316 / 그룹단어체커 / 실버 5
package Gihyun.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BOJ_1316 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int input = Integer.parseInt(br.readLine());
		String word;
		int count = 0;
		
		for(int i=0;i<input;i++) {
			word = br.readLine();
			char []arr_word = word.toCharArray();
			List<Integer> list = new ArrayList<>();
			for(int j:arr_word) {
				list.add(word.indexOf(j));
				
			}
		}
	}

}
