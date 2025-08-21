package GIL.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Solution11047 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int price = Integer.parseInt(st.nextToken());
		int result = 0;
		
		List<Integer> list = new ArrayList<>(n);

		for(int i = 0; i < n; i++) {
		    list.add(Integer.parseInt(br.readLine().trim()));
		}
		list.sort(Comparator.reverseOrder()); // 내림차순 한 줄
		
		for(int x : list) {
			result += price / x;
			price %= x;
		}
		System.out.println(result);
		br.close();
		
		
	}

}
