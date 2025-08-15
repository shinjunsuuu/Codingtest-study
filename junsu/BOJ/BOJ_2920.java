package junsu.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2920 {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		String arr[] = input.split(" ");
		
		boolean asc = true;
		boolean desc = true;
		
		for(int i = 0; i < arr.length - 1;i++) {
			int a = Integer.parseInt(arr[i]);
			int b = Integer.parseInt(arr[i+1]);
			
			if(a>b) asc = false;
			else if(a<b) desc = false;
			else {
				asc = false;
				desc = false;
			}
		}
		
		if(asc) System.out.println("ascending");
		else if(desc) System.out.println("descending");
		else System.out.println("mixed");
	}
	
}
