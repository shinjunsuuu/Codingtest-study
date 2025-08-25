package GIL.BOJ;

import java.io.*;
import java.util.*;

public class Solution1546 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		int[] nums = new int[n];
		double answer = 0;
		double max = 0;
		
		StringTokenizer st = new StringTokenizer(br.readLine());

		for (int i = 0; i < n; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
			if(nums[i]>max) {
				max = nums[i];
			}
		}
		
		for(int i = 0; i < nums.length; i++) {
			answer += nums[i] / max * 100;
		}

		System.out.println(answer / n);
	}

}

