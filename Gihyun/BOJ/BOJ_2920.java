package Gihyun.BOJ;

import java.util.Scanner;

public class BOJ_2920 {

	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		int []note=new int[8];
		
		for(int i=0;i<8;i++) {
			note[i]=scan.nextInt();
		}
		scan.close();
		
		StringBuilder result=new StringBuilder();
		
		for(int i : note) {
			result.append(i);
		}
		
		if(result.toString().equals("12345678")) {
			System.out.println("ascending");
		}else if(result.toString().equals("87654321")){
			System.out.println("descending");
		}else {
			System.out.println("mixed");
		}
	}

}