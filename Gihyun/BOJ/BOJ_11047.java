// 11047 / 동전 0 / 실버4 
package Gihyun.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class BOJ_11047 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String input = br.readLine();
		String [] nk = input.split(" ");
		int N = Integer.parseInt(nk[0]);
		int K = Integer.parseInt(nk[1]);
		
		int []array = new int[N];
		int count = 0;
		
		for(int i=N-1;i>=0;i--) {
			array[i]=Integer.parseInt(br.readLine());
		}
		
		for(int i:array) {
			count+=K/i;
			K%=i;
		}
		
		System.out.println(count);
		
	}
}
