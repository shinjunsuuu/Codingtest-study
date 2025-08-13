package GIL;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution2675 {

	public static void main(String[] agrs) throws IOException {
	      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	      int num1 = Integer.parseInt(br.readLine());
	      String[] result = null;

	      for (int i = 0; i < num1; i++) {
	         String line = br.readLine();
	         String[] num2 = line.split(" ");
	         int repeat = Integer.parseInt(num2[0]);
	         result = num2[1].split("");
	         for (int j = 0; j < result.length; j++) {
	            for (int k = 0; k < repeat; k++) {
	               System.out.print(result[j]);
	            }
	         }
	         System.out.println();
	      }
	      br.close();
	   }
}
