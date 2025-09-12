package GIL.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2748_피보나치수2 {

	static int n;
    
    static public long fibo(int n) {
        
        if(n < 2){
            return n;
        }
        
        long bp[] = new long[n+1];
        
        bp[0] = 0;
        bp[1] = 1;
        
        for(int i = 2; i <= n; i++){
            bp[i] = bp[i-1] + bp[i-2];
        }
        
        
        return bp[n];
    }
    
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        n = Integer.parseInt(br.readLine());
        System.out.println(fibo(n));
            
        br.close();
    }

}
