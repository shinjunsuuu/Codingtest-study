package GIL;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution2750 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int a = Integer.parseInt(br.readLine());
		int[] num = new int[a];
		for (int i = 0; i < a; i++) {
			num[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(num);
		for (int value : num) {
            System.out.println(value);
        }
		br.close();
	}
}
