import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1463 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int count=0;
        int i=1;
        while(i*3<n) {
        i*=3;
        count++;
        }
        while(i*2<n) {
            i*=2;
            count++;
        }
        while(i+1<=n) {
        i++;
        count++;
        }
            System.out.println(count);
        }
    }

