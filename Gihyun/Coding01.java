package Gihyun;

import java.util.Scanner;

public class Coding01 {

	public static void main(String[] args) {
		Scanner scan= new Scanner(System.in);
		int amount=scan.nextInt();
		scan.nextLine();
		String number=scan.nextLine();
		int []arraynum=new int [amount];
		
		int index=0;
		for(int i:number.toCharArray()) {
			arraynum[index++]=i-'0';
		}
		
		int sum=0;
		for(int i:arraynum) {
			sum+=i;
		}
		
		System.out.println("출력 : "+sum);
		
	
	}

}
