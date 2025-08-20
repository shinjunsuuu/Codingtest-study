package Gihyun.BOJ;

import java.util.Scanner;

public class BOJ_10809 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String S=sc.next();
		
		char[]word=new char[S.length()];
		word=S.toCharArray();
		
		boolean index=false;
		
		for(char i='a';i<='z';i++) {
			for(int m=0;m<word.length;m++) {
			if(i==word[m]) {
				System.out.print(m+" ");
				index=true;
				break;
				
			  } 
			}
			if(index==true) {
				index=false;
				continue;
			}else {
			System.out.print(-1+" ");
		    }
		}
	}
}
