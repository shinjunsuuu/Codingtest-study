package Gihyun.BOJ;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_2750 {

	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		int N=scan.nextInt();
		int []numbers= new int[N];
		
		for(int i=0;i<N;i++) {
			int input=scan.nextInt();
			numbers[i]=input;
		}
		Arrays.sort(numbers);
		
		for(int n=0;n<numbers.length;n++) {
			System.out.println(numbers[n]);
		}
	}

}