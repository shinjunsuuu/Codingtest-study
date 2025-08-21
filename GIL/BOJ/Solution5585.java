package GIL.BOJ;

import java.io.*;
import java.util.*;

public class Solution5585 {
	
	static int n, max;
	static double answer;
	static int[] nums;

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine()); 
		
		nums = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
			if(nums[i] > max) {
				max = nums[i];
			}
		}
		
		for(int i = 0; i < n; i++) {
			answer += (double) nums[i] /max * 100;
		}
		
		System.out.println(answer / n);
		
		
	}

}
