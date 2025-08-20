package Gihyun.BOJ;

import java.util.Scanner;

public class BOJ_2675 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int T=scan.nextInt();
		
		StringBuilder result=new StringBuilder();
		
		for(int i=0;i<T;i++) {
			int R=scan.nextInt();
			String S=scan.next();
			
			char[] arrayS=S.toCharArray();
			
			for(char m:arrayS) {
				for(int r=0;r<R;r++) {
					result.append(m);
				}
			}
			result.append("\n");
		}
		scan.close();
		System.out.print(result);
	}
}