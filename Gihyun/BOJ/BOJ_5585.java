// 5585 / 거스름돈 / 브론즈2 / GIHYUN LEE

package Gihyun.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_5585 {

   public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int []change = {500,100,50,10,5,1}; 
      int count=0;
      
      String str_money = br.readLine();
      int money = 1000-Integer.parseInt(str_money);
      
      for(int i : change) {
         count+=money/i;
         money=money%i;
      }
      System.out.println(count);   
   }
}