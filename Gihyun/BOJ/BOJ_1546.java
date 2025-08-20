// 1546 / 평균 / 브론즈1 / GIHYUN LEE

package Gihyun.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1546 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 int num_subject = Integer.parseInt(br.readLine());
		 String [] rawscore = br.readLine().split(" ");
		 double [] fakescore=new double[num_subject];
		 double max=0;
		 double avg=0;
		 
		 for(String i:rawscore) {
			 max = Math.max(max, Double.parseDouble(i));
		 }
		 
		 for(int i=0;i<rawscore.length;i++) {
			 fakescore[i] = Double.parseDouble(rawscore[i])/max*100.0;
			 avg+=fakescore[i];
		 }
		 
		 System.out.println(avg/num_subject);
	}
}